package parser.model.impl

import parser.IBuilder
import parser.IDataFinder
import parser.model.IExecutable
import parser.model.TernaryValidity
import parser.model.exceptions.BuilderException

class Validator private constructor(
    val steps: List<Step>,
) : IExecutable<Validator.Result> {
    data class Result(
        val validity: TernaryValidity,
        val messages: Map<String, String?>,
    ) {
        operator fun plus(other: Result): Result {
            return Result(
                validity * other.validity,
                (messages + other.messages).entries.filter { entry -> entry.value != null }
                    .fold(mutableMapOf<String, String>()) { acc, entry ->
                        acc[entry.key] = entry.value!!
                        acc
                    }
            )
        }
    }

    class Builder : IBuilder<Validator> {
        private val steps = mutableListOf<Step>()

        fun addStep(step: Step): Builder {
            steps.add(step)
            return this
        }

        override fun build(): Validator {
            if (steps.isEmpty()) {
                throw BuilderException("ValidatorBuilder", "'steps' is empty")
            }
            return Validator(this.steps)
        }
    }

    override fun execute(root: Any?, dataFinder: IDataFinder): Result {
        return steps.map { it.execute(root, dataFinder) }
            .map {
                if (it.message != null) {
                    Result(it.validity, mapOf(Pair(it.stepName, it.message)))
                } else {
                    Result(it.validity, emptyMap())
                }
            }
            .reduce { left, right -> left + right }
    }

    override fun toString(): String {
        return """{"steps": [${steps.joinToString(",") { it.toString() }}]}"""
    }
}