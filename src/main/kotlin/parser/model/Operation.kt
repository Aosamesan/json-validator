package parser.model

import parser.IBuilder
import parser.model.exceptions.BuilderException

typealias Operator = (actual: Any?, expected: Any?, ignoreCase: Boolean) -> Operation.Result

class Operation private constructor(
    val ignoreCase: Boolean,
    val negate: Boolean,
    val op: Operator,
) {
    data class Result(
        val validity: TernaryValidity,
        val errorMessage: List<String> = emptyList(),
    ) {
        constructor(predicate: () -> Boolean): this(predicate().toTernaryValidity())
        constructor(boolean: Boolean): this(boolean.toTernaryValidity())

        operator fun plus(other: Result): Result {
            return Result(
                validity + other.validity,
                errorMessage + other.errorMessage
            )
        }

        operator fun times(other: Result): Result {
            return Result(
                validity * other.validity,
                errorMessage + other.errorMessage
            )
        }
    }

    class Builder : IBuilder<Operation> {
        var ignoreCase: Boolean = false
        var negate: Boolean = false
        var op: Operator? = null

        override fun build(): Operation {
            if (op == null) {
                throw BuilderException("OperationBuilder", "'op' must be set")
            }
            return Operation(ignoreCase, negate, op!!)
        }
    }

    fun execute(actual: Any?, expected: Any?): Result {
        val result = op(actual, expected, ignoreCase)
        if (negate) {
            return Result(
                !result.validity, result.errorMessage
            )
        }
        return result
    }

    override fun toString(): String {
        return """{"ignoreCase": $ignoreCase,"negate": $negate,"operation": "$op"}"""
    }
}