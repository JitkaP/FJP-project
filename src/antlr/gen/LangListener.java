// Generated from C:/workspace/KIV_FJP/src/antlr\Lang.g4 by ANTLR 4.7.2
package antlr.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LangParser}.
 */
public interface LangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(LangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(LangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(LangParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(LangParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(LangParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(LangParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#consts}.
	 * @param ctx the parse tree
	 */
	void enterConsts(LangParser.ConstsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#consts}.
	 * @param ctx the parse tree
	 */
	void exitConsts(LangParser.ConstsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#constarrays}.
	 * @param ctx the parse tree
	 */
	void enterConstarrays(LangParser.ConstarraysContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#constarrays}.
	 * @param ctx the parse tree
	 */
	void exitConstarrays(LangParser.ConstarraysContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#vars}.
	 * @param ctx the parse tree
	 */
	void enterVars(LangParser.VarsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#vars}.
	 * @param ctx the parse tree
	 */
	void exitVars(LangParser.VarsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(LangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(LangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#assignstmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignstmt(LangParser.AssignstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#assignstmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignstmt(LangParser.AssignstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#callstmt}.
	 * @param ctx the parse tree
	 */
	void enterCallstmt(LangParser.CallstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#callstmt}.
	 * @param ctx the parse tree
	 */
	void exitCallstmt(LangParser.CallstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#beginstmt}.
	 * @param ctx the parse tree
	 */
	void enterBeginstmt(LangParser.BeginstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#beginstmt}.
	 * @param ctx the parse tree
	 */
	void exitBeginstmt(LangParser.BeginstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#ifstmt}.
	 * @param ctx the parse tree
	 */
	void enterIfstmt(LangParser.IfstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#ifstmt}.
	 * @param ctx the parse tree
	 */
	void exitIfstmt(LangParser.IfstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#whilestmt}.
	 * @param ctx the parse tree
	 */
	void enterWhilestmt(LangParser.WhilestmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#whilestmt}.
	 * @param ctx the parse tree
	 */
	void exitWhilestmt(LangParser.WhilestmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#dowhilestmt}.
	 * @param ctx the parse tree
	 */
	void enterDowhilestmt(LangParser.DowhilestmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#dowhilestmt}.
	 * @param ctx the parse tree
	 */
	void exitDowhilestmt(LangParser.DowhilestmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#forstmt}.
	 * @param ctx the parse tree
	 */
	void enterForstmt(LangParser.ForstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#forstmt}.
	 * @param ctx the parse tree
	 */
	void exitForstmt(LangParser.ForstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#ternarstmt}.
	 * @param ctx the parse tree
	 */
	void enterTernarstmt(LangParser.TernarstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#ternarstmt}.
	 * @param ctx the parse tree
	 */
	void exitTernarstmt(LangParser.TernarstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#writestmt}.
	 * @param ctx the parse tree
	 */
	void enterWritestmt(LangParser.WritestmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#writestmt}.
	 * @param ctx the parse tree
	 */
	void exitWritestmt(LangParser.WritestmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#readstmt}.
	 * @param ctx the parse tree
	 */
	void enterReadstmt(LangParser.ReadstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#readstmt}.
	 * @param ctx the parse tree
	 */
	void exitReadstmt(LangParser.ReadstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(LangParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(LangParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(LangParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(LangParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#bool_expression}.
	 * @param ctx the parse tree
	 */
	void enterBool_expression(LangParser.Bool_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#bool_expression}.
	 * @param ctx the parse tree
	 */
	void exitBool_expression(LangParser.Bool_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#string_expression}.
	 * @param ctx the parse tree
	 */
	void enterString_expression(LangParser.String_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#string_expression}.
	 * @param ctx the parse tree
	 */
	void exitString_expression(LangParser.String_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#number_expression}.
	 * @param ctx the parse tree
	 */
	void enterNumber_expression(LangParser.Number_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#number_expression}.
	 * @param ctx the parse tree
	 */
	void exitNumber_expression(LangParser.Number_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(LangParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(LangParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(LangParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(LangParser.FactorContext ctx);
}