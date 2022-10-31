package parser.listener

import parser.IBuilder
import parser.ValidatorParser
import parser.ValidatorParserBaseListener
import parser.argument.ArgumentBuilder
import parser.model.IExpression
import parser.model.Operation
import parser.model.ResultMessage
import parser.model.impl.*
import java.util.LinkedList
import java.util.Stack

class ValidatorListener : ValidatorParserBaseListener(), IBuilder<Validator> {
    private val argumentBuilder = ArgumentBuilder()
    private val operationBuilderStack = Stack<Operation.Builder>()
    private val expressionBuilderStack = Stack<Expression.Builder>()
    private val expressionStack = Stack<IExpression>()
    private val messageBuilderStack = Stack<ResultMessage.Builder>()
    private val stepBuilderQueue = LinkedList<Step.Builder>()
    private val validatorBuilder = Validator.Builder()

    override fun build(): Validator {
        return validatorBuilder.build()
    }

    // step
    override fun enterSteps(ctx: ValidatorParser.StepsContext?) {
        stepBuilderQueue.push(Step.Builder())
        messageBuilderStack.push(ResultMessage.Builder())
    }

    override fun exitSteps(ctx: ValidatorParser.StepsContext?) {
        val builder = stepBuilderQueue.poll()
        val messageBuilder = messageBuilderStack.pop()
        builder.resultMessage = messageBuilder.build()
        builder.expressions = expressionStack.pop()
        validatorBuilder.addStep(builder.build())
    }

    // messages
    override fun exitInvalidMessage(ctx: ValidatorParser.InvalidMessageContext?) {
        val message = ctx?.message?.text ?: throw Exception("[exitInvalidMessage] null exception")
        messageBuilderStack.peek().whenInvalid = message.replace(Regex("^\"|\"$"), "")
    }

    override fun exitComplexMessageDeatilsWhenTrue(ctx: ValidatorParser.ComplexMessageDeatilsWhenTrueContext?) {
        val message = ctx?.message?.text ?: throw Exception("[exitComplexMessageWhenTrue] null exception")
        messageBuilderStack.peek().whenValid = message.replace(Regex("^\"|\"$"), "")
    }

    override fun exitComplexMessageDetailsWhenFalse(ctx: ValidatorParser.ComplexMessageDetailsWhenFalseContext?) {
        val message = ctx?.message?.text ?: throw Exception("[exitComplexMessageWhenFalse] null exception")
        messageBuilderStack.peek().whenInvalid = message.replace(Regex("^\"|\"$"), "")
    }

    // stepName
    override fun exitStepName(ctx: ValidatorParser.StepNameContext?) {
        val stepName = ctx?.text ?: throw Exception("[exitStepName] null exception")
        stepBuilderQueue.peek().stepName = stepName.replace(Regex("^\"|\"$"), "")
    }

    // expressions
    override fun exitExpressionsRest(ctx: ValidatorParser.ExpressionsRestContext?) {
        val right = expressionStack.pop()
        val left = expressionStack.pop()
        expressionStack.push(left + right)
    }

    // expression
    override fun exitExpressionRest(ctx: ValidatorParser.ExpressionRestContext?) {
        val right = expressionStack.pop()
        val left = expressionStack.pop()
        expressionStack.push(left * right)
    }

    // atomic expression
    override fun enterAtomicExpression(ctx: ValidatorParser.AtomicExpressionContext?) {
        if (ctx?.path() != null) {
            expressionBuilderStack.push(Expression.Builder())
        }
    }

    override fun exitAtomicExpression(ctx: ValidatorParser.AtomicExpressionContext?) {
        if (ctx?.path() != null) {
            expressionStack.push(expressionBuilderStack.pop().build())
        }
    }

    // path
    override fun exitPath(ctx: ValidatorParser.PathContext?) {
        val path = ctx?.text ?: throw Exception("[exitPath] null exception")
        expressionBuilderStack.peek().path = path.replace(Regex("^\"|\"$"), "")
    }

    // operations
    override fun enterOperations(ctx: ValidatorParser.OperationsContext?) {
        operationBuilderStack.push(Operation.Builder())
    }

    override fun exitOperations(ctx: ValidatorParser.OperationsContext?) {
        val operation = operationBuilderStack.pop().build()
        expressionBuilderStack.peek().operation = operation
    }

    // equality
    override fun exitNumberEqualityOperation(ctx: ValidatorParser.NumberEqualityOperationContext?) {
        val top = operationBuilderStack.peek()
        val op = ctx?.op?.text ?: throw Exception("[exitNumberEquality] null exception")
        if (op == "!=") {
            top.negate = true
        }
        top.op = Operations.NUMBER_EQUALITY
        expressionBuilderStack.peek().expected = argumentBuilder.getNumber()
    }

    override fun exitStringEqualityOperation(ctx: ValidatorParser.StringEqualityOperationContext?) {
        val top = operationBuilderStack.peek()
        val op = ctx?.op?.text ?: throw Exception("[exitStringEquality] null exception")
        if (op == "!=") {
            top.negate = true
        }
        expressionBuilderStack.peek().expected = argumentBuilder.getString()
        top.op = Operations.STRING_EQUALITY
    }

    override fun exitBooleanEqualityOperation(ctx: ValidatorParser.BooleanEqualityOperationContext?) {
        val top = operationBuilderStack.peek()
        expressionBuilderStack.peek().expected = argumentBuilder.getBoolean()
        top.op = Operations.BOOLEAN_EQUALITY
    }

    // check null
    override fun exitCheckNullOperation(ctx: ValidatorParser.CheckNullOperationContext?) {
        operationBuilderStack.peek().op = Operations.CHECK_NULL
    }

    // check empty
    override fun exitCheckEmptyOperation(ctx: ValidatorParser.CheckEmptyOperationContext?) {
        operationBuilderStack.peek().op = Operations.CHECK_EMPTY
    }

    // contains number
    override fun exitContainsNumber(ctx: ValidatorParser.ContainsNumberContext?) {
        operationBuilderStack.peek().op = Operations.CONTAINS_NUMBER
        expressionBuilderStack.peek().expected = argumentBuilder.getNumber()
    }

    // contains string
    override fun exitContainsString(ctx: ValidatorParser.ContainsStringContext?) {
        operationBuilderStack.peek().op = Operations.CONTAINS_STRING
        expressionBuilderStack.peek().expected = argumentBuilder.getString()
    }

    // contains null
    override fun exitContainsNull(ctx: ValidatorParser.ContainsNullContext?) {
        operationBuilderStack.peek().op = Operations.CONTAINS_NULL
    }

    // contains any of
    override fun exitContainsAnyOf(ctx: ValidatorParser.ContainsAnyOfContext?) {
        operationBuilderStack.peek().op = Operations.CONTAINS_ANY_OF
        expressionBuilderStack.peek().expected = argumentBuilder.getAsList()
    }

    // contains all of
    override fun exitContainsAllOf(ctx: ValidatorParser.ContainsAllOfContext?) {
        operationBuilderStack.peek().op = Operations.CONTAINS_ALL_OF
        expressionBuilderStack.peek().expected = argumentBuilder.getAsList()
    }

    // select
    override fun exitSelectOperation(ctx: ValidatorParser.SelectOperationContext?) {
        operationBuilderStack.peek().op = Operations.SELECT
        expressionBuilderStack.peek().expected = argumentBuilder.getAsList()
    }

    // negate, ignore case
    override fun exitNegate(ctx: ValidatorParser.NegateContext?) {
        operationBuilderStack.peek().negate = true
    }

    override fun exitIgnoreCase(ctx: ValidatorParser.IgnoreCaseContext?) {
        operationBuilderStack.peek().ignoreCase = true
    }

    // single argument
    override fun exitNumber(ctx: ValidatorParser.NumberContext?) {
        val token = ctx?.text ?: throw Exception("[exitNumber] null exception")
        argumentBuilder.register(token.toDouble())
    }

    override fun exitString(ctx: ValidatorParser.StringContext?) {
        val token = ctx?.text ?: throw Exception("[exitString] null exception")
        argumentBuilder.register(token)
    }

    override fun exitBoolean(ctx: ValidatorParser.BooleanContext?) {
        val token = ctx?.text ?: throw Exception("[exitBoolean] null exception")
        argumentBuilder.register(token.equals("true", true))
    }

    // array argument
    override fun exitNumberElement(ctx: ValidatorParser.NumberElementContext?) {
        val token = ctx?.text ?: throw Exception("[exitNumberElement] null exception")
        argumentBuilder.register(token.toDouble())
    }

    override fun exitStringElement(ctx: ValidatorParser.StringElementContext?) {
        val token = ctx?.text ?: throw Exception("[exitStringElement] null exception")
        argumentBuilder.register(token)
    }

    override fun exitBooleanElement(ctx: ValidatorParser.BooleanElementContext?) {
        val token = ctx?.text ?: throw Exception("[exitBooleanElement] null exception")
        argumentBuilder.register(token.equals("true", true))
    }

    override fun exitNullElement(ctx: ValidatorParser.NullElementContext?) {
        val token = ctx?.text ?: throw Exception("[exitNullElement] null exception")
        argumentBuilder.register(null)
    }
}