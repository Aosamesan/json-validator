// Generated from D:/workspace/json-validator/src/main/java/parser\ValidatorParser.g4 by ANTLR 4.10.1
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ValidatorParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ValidatorParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#validator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValidator(ValidatorParser.ValidatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#steps}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSteps(ValidatorParser.StepsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#stepName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStepName(ValidatorParser.StepNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#expressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressions(ValidatorParser.ExpressionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#expressionsRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionsRest(ValidatorParser.ExpressionsRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ValidatorParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#expressionRest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionRest(ValidatorParser.ExpressionRestContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#atomicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomicExpression(ValidatorParser.AtomicExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPath(ValidatorParser.PathContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#operations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperations(ValidatorParser.OperationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#equalityOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityOperation(ValidatorParser.EqualityOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#numberEqualityOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberEqualityOperation(ValidatorParser.NumberEqualityOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#stringEqualityOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringEqualityOperation(ValidatorParser.StringEqualityOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#booleanEqualityOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanEqualityOperation(ValidatorParser.BooleanEqualityOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#checkNullOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckNullOperation(ValidatorParser.CheckNullOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#checkEmptyOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheckEmptyOperation(ValidatorParser.CheckEmptyOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#containOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContainOperation(ValidatorParser.ContainOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#containsScalar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContainsScalar(ValidatorParser.ContainsScalarContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#containsNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContainsNumber(ValidatorParser.ContainsNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#containsString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContainsString(ValidatorParser.ContainsStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#containsNull}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContainsNull(ValidatorParser.ContainsNullContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#containsAnyOf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContainsAnyOf(ValidatorParser.ContainsAnyOfContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#containsAllOf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContainsAllOf(ValidatorParser.ContainsAllOfContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#selectOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectOperation(ValidatorParser.SelectOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#negate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegate(ValidatorParser.NegateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(ValidatorParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(ValidatorParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#boolean}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(ValidatorParser.BooleanContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#ignoreCase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgnoreCase(ValidatorParser.IgnoreCaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(ValidatorParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#arrayElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayElement(ValidatorParser.ArrayElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#numberElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberElement(ValidatorParser.NumberElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#stringElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringElement(ValidatorParser.StringElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#booleanElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanElement(ValidatorParser.BooleanElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#nullElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullElement(ValidatorParser.NullElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#messages}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessages(ValidatorParser.MessagesContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#invalidMessage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvalidMessage(ValidatorParser.InvalidMessageContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#complexMessage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplexMessage(ValidatorParser.ComplexMessageContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#complexMessageDetails}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplexMessageDetails(ValidatorParser.ComplexMessageDetailsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#complexMessageDeatilsWhenTrue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplexMessageDeatilsWhenTrue(ValidatorParser.ComplexMessageDeatilsWhenTrueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ValidatorParser#complexMessageDetailsWhenFalse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplexMessageDetailsWhenFalse(ValidatorParser.ComplexMessageDetailsWhenFalseContext ctx);
}