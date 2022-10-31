package parser.model

typealias TernaryValidityBinaryOperation = (left: TernaryValidity, right: TernaryValidity) -> TernaryValidity

enum class TernaryValidity {
    VALID, INVALID, ERROR;

    operator fun plus(other: TernaryValidity): TernaryValidity {
        return if (this == ERROR || other == ERROR) {
            ERROR
        } else if (this == VALID || other == VALID) {
            VALID
        } else {
            INVALID
        }
    }

    operator fun times(other: TernaryValidity): TernaryValidity {
        return if (this == ERROR || other == ERROR) {
            ERROR
        } else if (this == VALID && other == VALID) {
            VALID
        } else {
            INVALID
        }
    }

    operator fun not(): TernaryValidity {
        return when(this) {
            VALID -> INVALID
            INVALID -> VALID
            ERROR -> ERROR
        }
    }
}

fun Boolean.toTernaryValidity(): TernaryValidity {
    return if (this) {
        TernaryValidity.VALID
    } else {
        TernaryValidity.INVALID
    }
}