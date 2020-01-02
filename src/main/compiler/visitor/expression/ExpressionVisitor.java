package main.compiler.visitor.expression;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.expression.BoolExpression;
import main.compiler.entity.expression.Expression;
import main.compiler.entity.expression.NumberExpression;
import main.compiler.entity.expression.StringExpression;

/**
 * Visitor for Expression class.
 */
public class ExpressionVisitor extends LangBaseVisitor<Expression> {

    /**
     * Method for visit Expression
     * @param ctx context of the Expression
     * @return object of StringExpression, NumberExpression or
     *         BoolExpression class (all of these classes extends Expression)
     */
    @Override
    public Expression visitExpression(LangParser.ExpressionContext ctx) {
        if (ctx.string_expression() != null) {
            StringExpression stringExpression = new StringExpressionVisitor().visit(ctx.string_expression());
            return stringExpression;
        } else if (ctx.number_expression() != null) {
            NumberExpression numberExpression = new NumberExpressionVisitor().visit(ctx.number_expression());
            return numberExpression;
        } else if (ctx.bool_expression() != null) {
            BoolExpression boolExpression = new BoolExpressionVisitor().visit(ctx.bool_expression());
            return boolExpression;
        }

        return null;
    }
}
