package main.compiler.visitor.statement;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.expression.NumberExpression;
import main.compiler.entity.statement.ForStatement;
import main.compiler.entity.statement.Statement;
import main.compiler.visitor.expression.NumberExpressionVisitor;

/**
 * Visitor for ForStatement class.
 */
public class ForStatementVisitor extends LangBaseVisitor<ForStatement> {

    /**
     * Method for visit ForStatement
     * @param ctx context of the ForStatement
     * @return object of ForStatement class
     */
    @Override
    public ForStatement visitForstmt(LangParser.ForstmtContext ctx) {
        String name = ctx.ident().getText();
        NumberExpression from = new NumberExpressionVisitor().visit(ctx.number_expression(0));
        NumberExpression to = new NumberExpressionVisitor().visit(ctx.number_expression(1));
        Statement statement = new StatementVisitor().visit(ctx.statement());

        return new ForStatement(name, from, to, statement);
    }
}
