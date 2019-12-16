// Generated from C:/Users/Jitka/Desktop/1920-ZS/FJP/FJP-project/src/antlr\Lang.g4 by ANTLR 4.7.2
package antlr.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(LangParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(LangParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(LangParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#procedure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedure(LangParser.ProcedureContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#consts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConsts(LangParser.ConstsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#constarrays}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstarrays(LangParser.ConstarraysContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#vars}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVars(LangParser.VarsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(LangParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#assignstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignstmt(LangParser.AssignstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#callstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallstmt(LangParser.CallstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#beginstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeginstmt(LangParser.BeginstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#ifstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstmt(LangParser.IfstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#whilestmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhilestmt(LangParser.WhilestmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#dowhilestmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDowhilestmt(LangParser.DowhilestmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#forstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForstmt(LangParser.ForstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#ternarstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernarstmt(LangParser.TernarstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#writestmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWritestmt(LangParser.WritestmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#readstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadstmt(LangParser.ReadstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(LangParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(LangParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#bool_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_expression(LangParser.Bool_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#string_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_expression(LangParser.String_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#number_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber_expression(LangParser.Number_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(LangParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(LangParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#ident}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdent(LangParser.IdentContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(LangParser.ValueContext ctx);
}