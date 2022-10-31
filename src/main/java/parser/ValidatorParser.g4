parser grammar ValidatorParser;

options {
    tokenVocab = ValidatorLexer;
}

validator: VALIDATOR VALIDATOR_LPAREN steps VALIDATOR_RPAREN EOF;
steps: STEP stepName STEP_START_EXPR expressions (messages | STEP_END_EXPR)?;
stepName: STEP_STRING;
expressions: expression (EXPR_COMPOSITION_OR expression)*;
expression: atomicExpression (EXPR_COMPOSITION_AND atomicExpression)*;
atomicExpression
    : EXPR_GET EXPR_PATH_LPAREN path EXPR_PATH_RPAREN operations
    | EXPR_PATH_LPAREN expressions EXPR_PATH_RPAREN
    ;
path: EXPR_STRING;
operations
    : equalityOperation
    | checkNullOperation
    | checkEmptyOperation
    | containOperation
    | selectOperation
    ;

// equality
equalityOperation
    : numberEqualityOperation
    | stringEqualityOperation
    | booleanEqualityOperation
    ;
numberEqualityOperation: op=(OP_EQUAL | OP_NOT_EQUAL) number;
stringEqualityOperation: op=(OP_EQUAL | OP_NOT_EQUAL) string ignoreCase?;
booleanEqualityOperation: OP_IS negate? boolean;

// check null
checkNullOperation: OP_IS negate? OPND_NULL;

// check emptiness
checkEmptyOperation: OP_IS negate? OPND_EMPTY;

// containOperation ([] contains _ (scalar), [] contains any of [], [] contains all of [])
containOperation
    : containsScalar
    | containsAnyOf
    | containsAllOf
    ;
containsScalar
    : containsNumber
    | containsString
    | containsNull
    ;
containsNumber: OP_CONTAINS negate? number;
containsString: OP_CONTAINS negate? string ignoreCase?;
containsNull: OP_CONTAINS negate? OPND_NULL;
containsAnyOf: OP_CONTAINS negate? QUANTIFIER_ANY OP_OF array ignoreCase?;
containsAllOf: OP_CONTAINS negate? QUANTIFIER_ALL OP_OF array ignoreCase?;

// selectOepration ({scalar} is one of [])
selectOperation: OP_IS negate? QUANTIFIER_ONE OP_OF array ignoreCase?;

negate: OP_NOT;
number: OPND_NUMBER;
string: EXPR_STRING;
boolean: OPND_BOOLEAN;
ignoreCase: ADDITIVE_IGNORE ADDITIVE_CASE;
array: OPND_ARRAY_START arrayElement (OPND_ARRAY_COMMA arrayElement)* OPND_ARRAY_END;
arrayElement: numberElement | stringElement | booleanElement | nullElement;
numberElement: OPND_NUMBER;
stringElement: EXPR_STRING;
booleanElement: OPND_BOOLEAN;
nullElement: OPND_NULL;

// message
messages
    : invalidMessage
    | complexMessage
    ;

invalidMessage: STEP_START_MESSAGE message=EXPR_STRING STEP_END_EXPR;
complexMessage: STEP_START_COMPLEX_MESSAGE complexMessageDetails STEP_END_COMPLEX_MESSAGE;
complexMessageDetails
    : complexMessageDeatilsWhenTrue complexMessageDetailsWhenFalse
    | complexMessageDetailsWhenFalse complexMessageDeatilsWhenTrue
    ;

complexMessageDeatilsWhenTrue
    : COMPLEX_MESSAGE_WHEN COMPLEX_MESSAGE_VALID COMPLEX_MESSAGE_COLON message=COMPLEX_MESSAGE_STRING COMPLEX_MESSAGE_SEMICOLON;
complexMessageDetailsWhenFalse
    : COMPLEX_MESSAGE_WHEN COMPLEX_MESSAGE_INVALID COMPLEX_MESSAGE_COLON message=COMPLEX_MESSAGE_STRING COMPLEX_MESSAGE_SEMICOLON;