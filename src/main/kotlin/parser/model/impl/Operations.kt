package parser.model.impl

import parser.model.Operation
import parser.model.Operator

enum class Operations(val op: Operator): Operator {
    NUMBER_EQUALITY(Operators::numberEquality),
    STRING_EQUALITY(Operators::stringEquality),
    BOOLEAN_EQUALITY(Operators::booleanEquality),
    CHECK_NULL(Operators::checkNull),
    CHECK_EMPTY(Operators::checkEmpty),
    CONTAINS_NUMBER(Operators::containsNumber),
    CONTAINS_STRING(Operators::containsString),
    CONTAINS_NULL(Operators::containsNull),
    CONTAINS_ANY_OF(Operators::containsAnyOf),
    CONTAINS_ALL_OF(Operators::containsAllOf),
    SELECT(Operators::select)
    ;

    override fun invoke(actual: Any?, expected: Any?, ignoreCase: Boolean): Operation.Result {
        return op(actual, expected, ignoreCase)
    }

    override fun toString(): String {
        return name
    }
}
