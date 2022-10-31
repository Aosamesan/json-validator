package parser.model

import parser.IBuilder
import parser.model.exceptions.BuilderException

class ResultMessage private constructor(
    val whenInvalid: String?,
    val whenValid: String?
) {
    class Builder : IBuilder<ResultMessage> {
        var whenInvalid: String? = null
        var whenValid: String? = null

        override fun build(): ResultMessage {
            return ResultMessage(whenInvalid, whenValid)
        }
    }

    override fun toString(): String {
        return """{"whenInvalid": ${
            if (whenInvalid == null) {
                "null"
            } else {
                "\"$whenInvalid\""
            }
        },"whenValid": ${
            if (whenValid == null) {
                "null"
            } else {
                "\"$whenValid\""
            }
        }}"""
    }
}