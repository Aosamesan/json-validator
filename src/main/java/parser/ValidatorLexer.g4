// ValidatorLexer.g4
lexer grammar ValidatorLexer;

// fragments
fragment DOT: '.';
fragment COMMA: ',';
fragment COLON: ':';
fragment SEMICOLON: ';';
fragment LPAREN: '(';
fragment RPAREN: ')';
fragment LCBRACKET: '{';
fragment RCBRACKET: '}';
fragment LBRACKET: '[';
fragment RBRACKET: ']';
fragment WS: [ \r\n\t];

fragment INTEGER: '0' | [1-9][0-9]*;
fragment SIGNED_INTEGER: [+\-] INTEGER;
fragment FLOAT: SIGNED_INTEGER (COMMA INTEGER?)? ([Ee] SIGNED_INTEGER)?;
fragment HEX: [0-9a-fA-F];
fragment UNICODE: 'u' HEX HEX HEX HEX;
fragment ESCAPE_SEQUENCE: '\\' (["\\bfnrt] | UNICODE);
fragment SAFE_CODEPOINT: ~["\\\u0000-\u001F];
fragment STRING: '"' (ESCAPE_SEQUENCE | SAFE_CODEPOINT)* '"';

// start
VALIDATOR: 'validator';
VALIDATOR_LPAREN: LCBRACKET -> pushMode(MODE_STEPS) ;
VALIDATOR_WS: WS -> skip;

// Steps
mode MODE_STEPS;
VALIDATOR_RPAREN: RCBRACKET -> popMode;
STEP: 'step';
STEP_STRING: STRING;
STEP_LPAREN: LPAREN;
STEP_RPAREN: RPAREN;
STEP_START_EXPR: COLON -> pushMode(MODE_EXPR);
STEP_WS: WS -> skip;

// Expression
mode MODE_EXPR;
STEP_END_EXPR: SEMICOLON -> popMode;
EXPR_STRING: STRING;
EXPR_GET: 'get';
EXPR_PATH_LPAREN: LPAREN;
EXPR_PATH_RPAREN: RPAREN;
STEP_START_MESSAGE: '->';
STEP_START_COMPLEX_MESSAGE: LCBRACKET -> pushMode(MODE_COMPLEX_MESSAGE);

// Compositions
EXPR_COMPOSITION_AND: 'and';
EXPR_COMPOSITION_OR: 'or';

// Operation
OP_EQUAL: '==';
OP_NOT_EQUAL: '!=';
OP_NOT: 'not';
OP_IS: 'is';
OP_CONTAINS: 'contains';
OP_OF: 'of';

// Operands
OPND_NULL: 'null';
OPND_EMPTY: 'empty';
OPND_ARRAY_START: LBRACKET;
OPND_ARRAY_END: RBRACKET;
OPND_ARRAY_COMMA: COMMA;
OPND_NUMBER: INTEGER | SIGNED_INTEGER | FLOAT;
OPND_TRUE: 'true';
OPND_FALSE: 'false';
OPND_BOOLEAN: OPND_TRUE | OPND_FALSE;

// Quantifiers
QUANTIFIER_ALL: 'all';
QUANTIFIER_ANY: 'any';
QUANTIFIER_ONE: 'one';

// additive info
ADDITIVE_IGNORE: 'ignore';
ADDITIVE_CASE: 'case';

// white spaces
EXPR_WS: WS -> skip;

mode MODE_COMPLEX_MESSAGE;
STEP_END_COMPLEX_MESSAGE: RCBRACKET -> popMode, popMode;
COMPLEX_MESSAGE_STRING: STRING;
COMPLEX_WS: WS -> skip;
COMPLEX_MESSAGE_WHEN: 'when';
COMPLEX_MESSAGE_VALID: 'valid';
COMPLEX_MESSAGE_INVALID: 'invalid';
COMPLEX_MESSAGE_COLON: COLON;
COMPLEX_MESSAGE_SEMICOLON: SEMICOLON;
