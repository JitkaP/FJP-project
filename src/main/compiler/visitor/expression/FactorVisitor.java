package main.compiler.visitor.expression;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.expression.Factor;
import main.compiler.entity.expression.NumberExpression;
import main.compiler.entity.value.IdentValue;
import main.compiler.entity.value.IntValue;
import main.compiler.entity.value.Value;

public class FactorVisitor extends LangBaseVisitor<Factor> {

    @Override
    public Factor visitFactor(LangParser.FactorContext ctx) {
        // options: ident, NUMBER, number_expression

        if (ctx.ident() != null) {
            Value value = new IdentValue(ctx.ident().getText());
            return new Factor(value);
        } else if (ctx.NUMBER() != null) {
            Value value = new IntValue(Integer.parseInt(ctx.NUMBER().getText()));
            return new Factor(value);
        } else { //if (ctx.number_expression() != null) {
            NumberExpression numberExpression = new NumberExpressionVisitor().visit(ctx.number_expression());
            return new Factor(numberExpression);
        }
    }
}
