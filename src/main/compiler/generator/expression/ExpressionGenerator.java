package main.compiler.generator.expression;

import main.compiler.entity.expression.BoolExpression;
import main.compiler.entity.expression.Expression;
import main.compiler.entity.expression.NumberExpression;
import main.compiler.entity.expression.StringExpression;
import main.compiler.generator.Generator;

public class ExpressionGenerator extends Generator {

    private Expression expression;

    public ExpressionGenerator(Expression expression) {
        this.expression = expression;
    }

    public void generate() {
        if (expression instanceof NumberExpression) {
            (new NumberExpressionGenerator((NumberExpression) expression)).generate();
        } else if (expression instanceof BoolExpression) {
            (new BoolExpressionGenerator((BoolExpression) expression)).generate();
        } else if (expression instanceof StringExpression) {
            (new StringExpressionGenerator((StringExpression) expression)).generate();
        }
    }

}
