package parser.model.impl

import parser.IBuilder
import parser.IDataFinder
import parser.model.*
import parser.model.exceptions.BuilderException

open class Expression private constructor(
    val path: String,
    val operation: Operation,
    val expected: Any?,
) : IExpression {

    class Builder : IBuilder<IExpression> {
        var path: String? = null
        var operation: Operation? = null
        var expected: Any? = null

        override fun build(): IExpression {
            if (path == null) {
                throw BuilderException("ExpressionBuilder", "'path' must be set")
            }
            if (operation == null) {
                throw BuilderException("ExpressionBuilder", "'operation' must be set")
            }
            return Expression(path!!, operation!!, expected)
        }
    }

    override fun plus(other: IExpression): IExpression {
        return when (other) {
            is CompoundExpression -> {
                when (other.type) {
                    CompoundExpression.Type.LogicalAnd -> {
                        CompoundExpression(CompoundExpression.Type.LogicalOr, this, other)
                    }

                    CompoundExpression.Type.LogicalOr -> {
                        CompoundExpression(CompoundExpression.Type.LogicalOr, this, *other.expressions.toTypedArray())
                    }
                }
            }

            is Expression -> {
                CompoundExpression(CompoundExpression.Type.LogicalOr, this, other)
            }

            else -> throw Exception("Unreachable")
        }
    }

    override fun times(other: IExpression): IExpression {
        return when (other) {
            is CompoundExpression -> {
                when (other.type) {
                    CompoundExpression.Type.LogicalAnd -> {
                        CompoundExpression(CompoundExpression.Type.LogicalAnd, this, *other.expressions.toTypedArray())
                    }

                    CompoundExpression.Type.LogicalOr -> {
                        CompoundExpression(CompoundExpression.Type.LogicalAnd, this, other)
                    }
                }
            }

            is Expression -> {
                CompoundExpression(CompoundExpression.Type.LogicalAnd, this, other)
            }

            else -> throw Exception("Unreachable")
        }
    }

    override fun execute(root: Any?, dataFinder: IDataFinder): Operation.Result {
        val actual = dataFinder.find(root, path)
        return operation.execute(actual, expected)
    }

    override fun toString(): String {
        val expectedValue = if (expected is String) {
            "\"$expected\""
        } else {
            expected
        }
        return """{"path": "$path","operation": $operation,"expected": {"type": "${expected?.javaClass ?: "null"}","value": $expectedValue}}"""
    }
}