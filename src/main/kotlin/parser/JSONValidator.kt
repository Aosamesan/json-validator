package parser

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import parser.listener.ValidatorListener
import parser.model.impl.Validator

fun createValidator(definition: String): Validator {
    val charStream = CharStreams.fromString(definition)
    val lexer = ValidatorLexer(charStream)
    val tokenStream = CommonTokenStream(lexer)
    val parser = ValidatorParser(tokenStream)
    val listener = ValidatorListener()
    val tree = parser.validator()
    ParseTreeWalker.DEFAULT.walk(listener, tree)
    return listener.build()
}