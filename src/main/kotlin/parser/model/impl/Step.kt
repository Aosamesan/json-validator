package parser.model.impl

import parser.IBuilder
import parser.IDataFinder
import parser.model.*
import parser.model.exceptions.BuilderException

class Step private constructor(
    val stepName: String,
    val expressions: IExpression,
    val resultMessage: ResultMessage?
): IExecutable<Step.Result> {
    class Builder : IBuilder<Step> {
        var stepName: String? = null
        var expressions: IExpression? = null
        var resultMessage: ResultMessage? = null

        override fun build(): Step {
            if (stepName == null) {
                throw BuilderException("StepBuilder", "'stepName' must be set")
            }
            if (expressions == null) {
                throw BuilderException("StepBuilder", "'expressions' must be set")
            }
            return Step(stepName!!, expressions!!, resultMessage)
        }
    }

    data class Result(
        val stepName: String,
        val validity: TernaryValidity,
        val message: String?
    )

    override fun execute(root: Any?, dataFinder: IDataFinder): Result {
        return expressions.execute(root, dataFinder).let { operationResult ->
            val resultValidity = operationResult.validity
            if (resultValidity == TernaryValidity.ERROR) {
                Result(stepName, TernaryValidity.ERROR, operationResult.errorMessage.let {
                    if (it.isEmpty()) {
                        null
                    } else {
                        it.joinToString("\n")
                    }
                })
            } else {
                Result(stepName, resultValidity, when (resultValidity) {
                    TernaryValidity.VALID -> resultMessage?.whenValid
                    TernaryValidity.INVALID -> resultMessage?.whenInvalid
                    else -> throw Exception("unreachable")
                })
            }
        }
    }

    override fun toString(): String {
        return """{"stepName": "$stepName", "expressions": $expressions, "resultMessage": $resultMessage}"""
    }
}