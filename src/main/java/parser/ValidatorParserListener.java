// Generated from D:/workspace/json-validator/src/main/java/parser\ValidatorParser.g4 by ANTLR 4.10.1
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ValidatorParser}.
 */
public interface ValidatorParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#validator}.
	 * @param ctx the parse tree
	 */
	void enterValidator(ValidatorParser.ValidatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#validator}.
	 * @param ctx the parse tree
	 */
	void exitValidator(ValidatorParser.ValidatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#steps}.
	 * @param ctx the parse tree
	 */
	void enterSteps(ValidatorParser.StepsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#steps}.
	 * @param ctx the parse tree
	 */
	void exitSteps(ValidatorParser.StepsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#stepName}.
	 * @param ctx the parse tree
	 */
	void enterStepName(ValidatorParser.StepNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#stepName}.
	 * @param ctx the parse tree
	 */
	void exitStepName(ValidatorParser.StepNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#expressions}.
	 * @param ctx the parse tree
	 */
	void enterExpressions(ValidatorParser.ExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#expressions}.
	 * @param ctx the parse tree
	 */
	void exitExpressions(ValidatorParser.ExpressionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#expressionsRest}.
	 * @param ctx the parse tree
	 */
	void enterExpressionsRest(ValidatorParser.ExpressionsRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#expressionsRest}.
	 * @param ctx the parse tree
	 */
	void exitExpressionsRest(ValidatorParser.ExpressionsRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ValidatorParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ValidatorParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#expressionRest}.
	 * @param ctx the parse tree
	 */
	void enterExpressionRest(ValidatorParser.ExpressionRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#expressionRest}.
	 * @param ctx the parse tree
	 */
	void exitExpressionRest(ValidatorParser.ExpressionRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#atomicExpression}.
	 * @param ctx the parse tree
	 */
	void enterAtomicExpression(ValidatorParser.AtomicExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#atomicExpression}.
	 * @param ctx the parse tree
	 */
	void exitAtomicExpression(ValidatorParser.AtomicExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#path}.
	 * @param ctx the parse tree
	 */
	void enterPath(ValidatorParser.PathContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#path}.
	 * @param ctx the parse tree
	 */
	void exitPath(ValidatorParser.PathContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#operations}.
	 * @param ctx the parse tree
	 */
	void enterOperations(ValidatorParser.OperationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#operations}.
	 * @param ctx the parse tree
	 */
	void exitOperations(ValidatorParser.OperationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#equalityOperation}.
	 * @param ctx the parse tree
	 */
	void enterEqualityOperation(ValidatorParser.EqualityOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#equalityOperation}.
	 * @param ctx the parse tree
	 */
	void exitEqualityOperation(ValidatorParser.EqualityOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#numberEqualityOperation}.
	 * @param ctx the parse tree
	 */
	void enterNumberEqualityOperation(ValidatorParser.NumberEqualityOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#numberEqualityOperation}.
	 * @param ctx the parse tree
	 */
	void exitNumberEqualityOperation(ValidatorParser.NumberEqualityOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#stringEqualityOperation}.
	 * @param ctx the parse tree
	 */
	void enterStringEqualityOperation(ValidatorParser.StringEqualityOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#stringEqualityOperation}.
	 * @param ctx the parse tree
	 */
	void exitStringEqualityOperation(ValidatorParser.StringEqualityOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#booleanEqualityOperation}.
	 * @param ctx the parse tree
	 */
	void enterBooleanEqualityOperation(ValidatorParser.BooleanEqualityOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#booleanEqualityOperation}.
	 * @param ctx the parse tree
	 */
	void exitBooleanEqualityOperation(ValidatorParser.BooleanEqualityOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#checkNullOperation}.
	 * @param ctx the parse tree
	 */
	void enterCheckNullOperation(ValidatorParser.CheckNullOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#checkNullOperation}.
	 * @param ctx the parse tree
	 */
	void exitCheckNullOperation(ValidatorParser.CheckNullOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#checkEmptyOperation}.
	 * @param ctx the parse tree
	 */
	void enterCheckEmptyOperation(ValidatorParser.CheckEmptyOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#checkEmptyOperation}.
	 * @param ctx the parse tree
	 */
	void exitCheckEmptyOperation(ValidatorParser.CheckEmptyOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#containOperation}.
	 * @param ctx the parse tree
	 */
	void enterContainOperation(ValidatorParser.ContainOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#containOperation}.
	 * @param ctx the parse tree
	 */
	void exitContainOperation(ValidatorParser.ContainOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#containsScalar}.
	 * @param ctx the parse tree
	 */
	void enterContainsScalar(ValidatorParser.ContainsScalarContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#containsScalar}.
	 * @param ctx the parse tree
	 */
	void exitContainsScalar(ValidatorParser.ContainsScalarContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#containsNumber}.
	 * @param ctx the parse tree
	 */
	void enterContainsNumber(ValidatorParser.ContainsNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#containsNumber}.
	 * @param ctx the parse tree
	 */
	void exitContainsNumber(ValidatorParser.ContainsNumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#containsString}.
	 * @param ctx the parse tree
	 */
	void enterContainsString(ValidatorParser.ContainsStringContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#containsString}.
	 * @param ctx the parse tree
	 */
	void exitContainsString(ValidatorParser.ContainsStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#containsNull}.
	 * @param ctx the parse tree
	 */
	void enterContainsNull(ValidatorParser.ContainsNullContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#containsNull}.
	 * @param ctx the parse tree
	 */
	void exitContainsNull(ValidatorParser.ContainsNullContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#containsAnyOf}.
	 * @param ctx the parse tree
	 */
	void enterContainsAnyOf(ValidatorParser.ContainsAnyOfContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#containsAnyOf}.
	 * @param ctx the parse tree
	 */
	void exitContainsAnyOf(ValidatorParser.ContainsAnyOfContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#containsAllOf}.
	 * @param ctx the parse tree
	 */
	void enterContainsAllOf(ValidatorParser.ContainsAllOfContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#containsAllOf}.
	 * @param ctx the parse tree
	 */
	void exitContainsAllOf(ValidatorParser.ContainsAllOfContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#selectOperation}.
	 * @param ctx the parse tree
	 */
	void enterSelectOperation(ValidatorParser.SelectOperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#selectOperation}.
	 * @param ctx the parse tree
	 */
	void exitSelectOperation(ValidatorParser.SelectOperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#negate}.
	 * @param ctx the parse tree
	 */
	void enterNegate(ValidatorParser.NegateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#negate}.
	 * @param ctx the parse tree
	 */
	void exitNegate(ValidatorParser.NegateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(ValidatorParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(ValidatorParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(ValidatorParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(ValidatorParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#boolean}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(ValidatorParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#boolean}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(ValidatorParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#ignoreCase}.
	 * @param ctx the parse tree
	 */
	void enterIgnoreCase(ValidatorParser.IgnoreCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#ignoreCase}.
	 * @param ctx the parse tree
	 */
	void exitIgnoreCase(ValidatorParser.IgnoreCaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(ValidatorParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(ValidatorParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#arrayElement}.
	 * @param ctx the parse tree
	 */
	void enterArrayElement(ValidatorParser.ArrayElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#arrayElement}.
	 * @param ctx the parse tree
	 */
	void exitArrayElement(ValidatorParser.ArrayElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#numberElement}.
	 * @param ctx the parse tree
	 */
	void enterNumberElement(ValidatorParser.NumberElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#numberElement}.
	 * @param ctx the parse tree
	 */
	void exitNumberElement(ValidatorParser.NumberElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#stringElement}.
	 * @param ctx the parse tree
	 */
	void enterStringElement(ValidatorParser.StringElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#stringElement}.
	 * @param ctx the parse tree
	 */
	void exitStringElement(ValidatorParser.StringElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#booleanElement}.
	 * @param ctx the parse tree
	 */
	void enterBooleanElement(ValidatorParser.BooleanElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#booleanElement}.
	 * @param ctx the parse tree
	 */
	void exitBooleanElement(ValidatorParser.BooleanElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#nullElement}.
	 * @param ctx the parse tree
	 */
	void enterNullElement(ValidatorParser.NullElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#nullElement}.
	 * @param ctx the parse tree
	 */
	void exitNullElement(ValidatorParser.NullElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#messages}.
	 * @param ctx the parse tree
	 */
	void enterMessages(ValidatorParser.MessagesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#messages}.
	 * @param ctx the parse tree
	 */
	void exitMessages(ValidatorParser.MessagesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#invalidMessage}.
	 * @param ctx the parse tree
	 */
	void enterInvalidMessage(ValidatorParser.InvalidMessageContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#invalidMessage}.
	 * @param ctx the parse tree
	 */
	void exitInvalidMessage(ValidatorParser.InvalidMessageContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#complexMessage}.
	 * @param ctx the parse tree
	 */
	void enterComplexMessage(ValidatorParser.ComplexMessageContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#complexMessage}.
	 * @param ctx the parse tree
	 */
	void exitComplexMessage(ValidatorParser.ComplexMessageContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#complexMessageDetails}.
	 * @param ctx the parse tree
	 */
	void enterComplexMessageDetails(ValidatorParser.ComplexMessageDetailsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#complexMessageDetails}.
	 * @param ctx the parse tree
	 */
	void exitComplexMessageDetails(ValidatorParser.ComplexMessageDetailsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#complexMessageDeatilsWhenTrue}.
	 * @param ctx the parse tree
	 */
	void enterComplexMessageDeatilsWhenTrue(ValidatorParser.ComplexMessageDeatilsWhenTrueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#complexMessageDeatilsWhenTrue}.
	 * @param ctx the parse tree
	 */
	void exitComplexMessageDeatilsWhenTrue(ValidatorParser.ComplexMessageDeatilsWhenTrueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ValidatorParser#complexMessageDetailsWhenFalse}.
	 * @param ctx the parse tree
	 */
	void enterComplexMessageDetailsWhenFalse(ValidatorParser.ComplexMessageDetailsWhenFalseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ValidatorParser#complexMessageDetailsWhenFalse}.
	 * @param ctx the parse tree
	 */
	void exitComplexMessageDetailsWhenFalse(ValidatorParser.ComplexMessageDetailsWhenFalseContext ctx);
}