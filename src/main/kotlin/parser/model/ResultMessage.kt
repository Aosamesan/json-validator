package parser.model

import parser.IBuilder
import parser.model.exceptions.BuilderException

class ResultMessage private constructor(
    val whenInvalid: String,
    val whenValid: String?
) {
    class Builder : IBuilder<ResultMessage> {
        var whenInvalid: String? = null
        var whenValid: String? = null

        override fun build(): ResultMessage {
            if (whenInvalid == null) {
                throw BuilderException("ResultMessageBuilder", "'whenInvalid' must be set")
            }
            return ResultMessage(whenInvalid!!, whenValid)
        }
    }

    override fun toString(): String {
        return """
            {
                "whenInvalid": $whenInvalid,
                "whenValid": $whenValid
            }
        """.trimIndent()
    }
}