package main.compiler.visitor.expression;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.expression.Factor;
import main.compiler.entity.expression.NumberExpression;
import main.compiler.entity.value.IdentValue;
import main.compiler.entity.value.IntValue;
import main.compiler.entity.value.Value;

/**
 * Visitor for Factor class.
 */
public class FactorVisitor extends LangBaseVisitor<Factor> {

    /**
     * Method for visit Factor
     * @param ctx context of the Factor
     * @return object of Factor class
     */
    @Override
    public Factor visitFactor(LangParser.FactorContext ctx) {
        // options: ident, NUMBER, number_expression

        if (ctx.ident() != null) {
            Value value = new IdentValue(ctx.ident().getText());
            return new Factor(value);
        } else if (ctx.ident_arr() != null) {
            String name = ctx.ident_arr().ident(0).getText();
            if (ctx.ident_arr().NUMBER() != null) {
                int index = Integer.parseInt(ctx.ident_arr().NUMBER().getText());
                Value value = new IdentValue(name, index);
                return new Factor(value);
            } else {
                String indexName = ctx.ident_arr().ident(1).getText();
                Value value = new IdentValue(name, indexName);
                return new Factor(value);
            }
        } else if (ctx.NUMBER() != null) {
            Value value = new IntValue(Integer.parseInt(ctx.NUMBER().getText()));
            return new Factor(value);
        } else {
            NumberExpression numberExpression = new NumberExpressionVisitor().visit(ctx.number_expression());
            return new Factor(numberExpression);
        }
    }
}
