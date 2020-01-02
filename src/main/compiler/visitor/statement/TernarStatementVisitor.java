package main.compiler.visitor.statement;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.Condition;
import main.compiler.entity.expression.Expression;
import main.compiler.entity.statement.TernarStatement;
import main.compiler.visitor.ConditionVisitor;
import main.compiler.visitor.expression.ExpressionVisitor;

/**
 * Visitor for TernarStatement class.
 */
public class TernarStatementVisitor extends LangBaseVisitor<TernarStatement> {

    /**
     * Method for visit TernarStatement
     * @param ctx context of the TernarStatement
     * @return object of TernarStatement class
     */
    @Override
    public TernarStatement visitTernarstmt(LangParser.TernarstmtContext ctx) {
        Condition condition = new ConditionVisitor().visit(ctx.condition());
        Expression leftExpression = new ExpressionVisitor().visit(ctx.expression(0));
        Expression rightExpression = new ExpressionVisitor().visit(ctx.expression(1));
        String name;

        if (ctx.ident() != null) {
            name = ctx.ident().getText();
            return new TernarStatement(name, condition, leftExpression, rightExpression);
        } else {
            name = ctx.ident_arr().ident(0).getText();
            if (ctx.ident_arr().NUMBER() != null) {
                int index = Integer.parseInt(ctx.ident_arr().NUMBER().getText());
                return new TernarStatement(name, index, condition, leftExpression, rightExpression);
            } else {
                String indexName = ctx.ident_arr().ident(1).getText();
                return new TernarStatement(name, indexName, condition, leftExpression, rightExpression);
            }
        }
    }

}
