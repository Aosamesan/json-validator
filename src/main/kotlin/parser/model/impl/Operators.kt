package parser.model.impl

import parser.model.Operation
import parser.model.TernaryValidity
import parser.model.toTernaryValidity

abstract class Operators {
    companion object {
        inline fun <reified T> unaryTypeCheck(
            actual: Any?,
            ignoreCase: Boolean,
            block: (actual: T, ignoreCase: Boolean) -> Operation.Result,
        ): Operation.Result {
            return when (actual) {
                null -> {
                    Operation.Result(TernaryValidity.INVALID)
                }

                !is T -> {
                    Operation.Result(TernaryValidity.ERROR, listOf("Target data is not an ${T::class}  (actual : ${actual::class})"))
                }

                else -> {
                    block(actual, ignoreCase)
                }
            }
        }

        inline fun <reified TActual, reified TExpected> binaryTypeCheck(
            actual: Any?,
            expected: Any?,
            ignoreCase: Boolean,
            block: (actual: TActual, expected: TExpected, ignoreCase: Boolean) -> Operation.Result,
        ): Operation.Result {
            if (expected !is TExpected) {
                return Operation.Result(TernaryValidity.ERROR, listOf("$expected is not a/an ${TExpected::class}"))
            }
            return when (actual) {
                null -> {
                    Operation.Result(TernaryValidity.INVALID)
                }

                !is TActual -> {
                    Operation.Result(TernaryValidity.ERROR, listOf("Target data is not an ${TActual::class} (actual : ${actual::class})"))
                }

                else -> {
                    block(actual, expected, ignoreCase)
                }
            }
        }

        fun numberEquality(actual: Any?, expected: Any?, ignoreCase: Boolean): Operation.Result {
            return binaryTypeCheck<Number, Number>(actual, expected, false) { actual, expected, ignoreCase ->
                Operation.Result(actual.toDouble() == expected.toDouble())
            }
        }

        fun stringEquality(actual: Any?, expected: Any?, ignoreCase: Boolean): Operation.Result {
            return binaryTypeCheck<String, String>(actual, expected, ignoreCase) { actual, expected, ignoreCase ->
                Operation.Result(actual.equals(expected, ignoreCase))
            }
        }

        fun booleanEquality(actual: Any?, expected: Any?, ignoreCase: Boolean): Operation.Result {
            return binaryTypeCheck<Boolean, Boolean>(actual, expected, false) { actual, expected, ignoreCase ->
                Operation.Result(actual == expected)
            }
        }

        fun checkNull(actual: Any?, expected: Any?, ignoreCase: Boolean): Operation.Result {
            return Operation.Result(actual == null)
        }

        fun checkEmpty(actual: Any?, expected: Any?, ignoreCase: Boolean): Operation.Result {
            return unaryTypeCheck<List<Any?>>(actual, false) { actual, ignoreCase ->
                Operation.Result(actual.isEmpty())
            }
        }

        fun containsNumber(actual: Any?, expected: Any?, ignoreCase: Boolean): Operation.Result = containsScalar<Double>(actual, expected, ignoreCase)

        fun containsString(actual: Any?, expected: Any?, ignoreCase: Boolean): Operation.Result = containsScalar<String>(actual, expected, ignoreCase)

        inline fun <reified T>containsScalar(actual: Any?, expected: Any?, ignoreCase: Boolean): Operation.Result {
            return binaryTypeCheck<List<Any?>, T>(actual, expected, ignoreCase) { actual, expected, ignoreCase ->
                if (ignoreCase && expected is String) {
                    Operation.Result(actual.filterIsInstance<String>().any { it.equals(expected, ignoreCase) })
                } else {
                    Operation.Result(actual.contains(expected))
                }
            }
        }

        fun containsNull(actual: Any?, expected: Any?, ignoreCase: Boolean): Operation.Result {
            if (actual !is List<Any?>) {
                return Operation.Result(TernaryValidity.ERROR, listOf("Data is not list"))
            }
            return Operation.Result(actual.contains(null).toTernaryValidity())
        }

        fun containsAnyOf(actual: Any?, expected: Any?, ignoreCase: Boolean): Operation.Result {
            return binaryTypeCheck<List<Any?>, List<Any?>>(actual, expected, ignoreCase) { actual, expected, ignoreCase ->
                if (ignoreCase) {
                    val lowerActual = actual.map {
                        if (it is String) {
                            it.lowercase()
                        } else {
                            it
                        }
                    }
                    val lowerExpected = expected.map {
                        if (it is String) {
                            it.lowercase()
                        } else {
                            it
                        }
                    }

                    Operation.Result(
                        lowerExpected.any { lowerActual.contains(it) }
                    )
                } else {
                    Operation.Result(
                        actual.any { a -> expected.any { it == a } }
                    )
                }
            }
        }

        fun containsAllOf(actual: Any?, expected: Any?, ignoreCase: Boolean): Operation.Result {
            return binaryTypeCheck<List<Any?>, List<Any?>>(actual, expected, ignoreCase) { actual, expected, ignoreCase ->
                if (ignoreCase) {
                    val lowerActual = actual.map {
                        if (it is String) {
                            it.lowercase()
                        } else {
                            it
                        }
                    }
                    val lowerExpected = expected.map {
                        if (it is String) {
                            it.lowercase()
                        } else {
                            it
                        }
                    }

                    Operation.Result(
                        lowerActual.containsAll(lowerExpected)
                    )
                } else {
                    Operation.Result(
                        actual.containsAll(expected)
                    )
                }
            }
        }

        fun select(actual: Any?, expected: Any?, ignoreCase: Boolean): Operation.Result {
            return binaryTypeCheck<Any?, List<Any?>>(actual, expected, ignoreCase) { actual, expected, ignoreCase ->
                if (ignoreCase && actual is String) {
                    Operation.Result(expected.filterIsInstance<String>().any{ actual.equals(it, ignoreCase)})
                } else {
                    Operation.Result(expected.contains(actual))
                }
            }
        }
    }
}
