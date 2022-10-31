package parser.model.impl

import parser.IDataFinder
import parser.model.IExpression
import parser.model.Operation

class CompoundExpression(val type: Type, vararg expressions: IExpression) : IExpression {
    val expressions = mutableListOf(*expressions)

    enum class Type(val composer: (Operation.Result, Operation.Result) -> Operation.Result) {
        LogicalAnd(Operation.Result::times),
        LogicalOr(Operation.Result::plus)
        ;

        fun execute(left: Operation.Result, right: Operation.Result): Operation.Result {
            return composer(left, right)
        }
    }

    override operator fun plus(other: IExpression): IExpression {
        return when (type) {
            Type.LogicalOr -> when (other) {
                is CompoundExpression -> {
                    if (other.type == Type.LogicalOr) {
                        CompoundExpression(
                            Type.LogicalOr,
                            *this.expressions.toTypedArray(),
                            *other.expressions.toTypedArray()
                        )
                    } else {
                        CompoundExpression(
                            Type.LogicalOr,
                            *this.expressions.toTypedArray(),
                            other
                        )
                    }
                }

                is Expression -> {
                    CompoundExpression(
                        Type.LogicalOr,
                        *this.expressions.toTypedArray(),
                        other
                    )
                }

                else -> throw Exception("Unreachable")
            }

            Type.LogicalAnd -> when (other) {
                is CompoundExpression -> {
                    if (other.type == Type.LogicalOr) {
                        CompoundExpression(
                            Type.LogicalOr,
                            this,
                            *other.expressions.toTypedArray()
                        )
                    } else {
                        CompoundExpression(
                            Type.LogicalOr,
                            this,
                            other
                        )
                    }
                }

                is Expression -> {
                    CompoundExpression(
                        Type.LogicalOr,
                        this,
                        other
                    )
                }

                else -> throw Exception("Unreachable")
            }
        }
    }

    override operator fun times(other: IExpression): IExpression {
        return when (type) {
            Type.LogicalAnd -> when (other) {
                is CompoundExpression -> {
                    if (other.type == Type.LogicalAnd) {
                        CompoundExpression(
                            Type.LogicalAnd,
                            *this.expressions.toTypedArray(),
                            *other.expressions.toTypedArray()
                        )
                    } else {
                        CompoundExpression(
                            Type.LogicalAnd,
                            *this.expressions.toTypedArray(),
                            other
                        )
                    }
                }

                is Expression -> {
                    CompoundExpression(
                        Type.LogicalAnd,
                        *this.expressions.toTypedArray(),
                        other
                    )
                }

                else -> throw Exception("Unreachable")
            }

            Type.LogicalOr -> when (other) {
                is CompoundExpression -> {
                    if (other.type == Type.LogicalAnd) {
                        CompoundExpression(
                            Type.LogicalAnd,
                            this,
                            *other.expressions.toTypedArray()
                        )
                    } else {
                        CompoundExpression(
                            Type.LogicalAnd,
                            this,
                            other
                        )
                    }
                }

                is Expression -> {
                    CompoundExpression(
                        Type.LogicalAnd,
                        this,
                        other
                    )
                }

                else -> throw Exception("Unreachable")
            }
        }
    }


    fun addExpressions(vararg expressions: IExpression): IExpression {
        this.expressions.addAll(listOf(*expressions))
        return this
    }

    override fun execute(root: Any?, dataFinder: IDataFinder): Operation.Result {
        return expressions.map { it.execute(root, dataFinder) }
            .reduce(type::execute)
    }

    override fun toString(): String {
        return """{"op": "$type","expressions": [${expressions.joinToString(",")}]}"""
    }
}