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
    class Expressions<T : IExpression> private constructor(
        private val expressions: List<T>,
        val binaryOp: TernaryValidityBinaryOperation,
    ) : Iterable<IExpression>, IExpression {
        enum class Type {
            LogicalAnd,
            LogicalOr
        }

        class Builder(private val type: Type) : IBuilder<Expressions<IExpression>> {
            private val expressions: MutableList<IExpression> = mutableListOf()

            fun addExpression(expression: IExpression): Builder {
                expressions.add(expression)
                return this
            }

            override fun build(): Expressions<IExpression> {
                if (expressions.isEmpty()) {
                    throw BuilderException("ExpressionsBuilder", "empty expressions")
                }
                return Expressions(
                    this.expressions, when (type) {
                        Type.LogicalOr -> TernaryValidity::plus
                        Type.LogicalAnd -> TernaryValidity::times
                    }
                )
            }
        }

        override fun iterator(): Iterator<IExpression> {
            return expressions.iterator()
        }

        override fun execute(root: Any?, dataFinder: IDataFinder): Operation.Result {
            return expressions.map { it.execute(root, dataFinder) }
                .reduce { left, right ->
                    return Operation.Result(
                        binaryOp(left.validity, right.validity),
                        left.errorMessage + right.errorMessage
                    )
                }
        }

        override fun toString(): String {
            val op = when(binaryOp) {
                TernaryValidity::plus -> "OR"
                TernaryValidity::times -> "AND"
                else -> "UNKNOWN"
            }

            return """
                {
                    "op": "$op",
                    "expressions": [${expressions.joinToString(",")}]
                }
            """.trimIndent()
        }
    }

    class Builder : IBuilder<Expression> {
        var path: String? = null
        var operation: Operation? = null
        var expected: Any? = null

        override fun build(): Expression {
            if (path == null) {
                throw BuilderException("ExpressionBuilder", "'path' must be set")
            }
            if (operation == null) {
                throw BuilderException("ExpressionBuilder", "'operation' must be set")
            }
            return Expression(path!!, operation!!, expected)
        }
    }

    override fun execute(root: Any?, dataFinder: IDataFinder): Operation.Result {
        val actual = dataFinder.find(root, path)
        return operation.execute(actual, expected)
    }

    override fun toString(): String {
        return """
            {
                "path": "$path",
                "operation": $operation,
                "expected": {
                    "type": "${expected?.javaClass ?: "null"}",
                    "value": "$expected"
                }
            }
        """.trimIndent()
    }
}