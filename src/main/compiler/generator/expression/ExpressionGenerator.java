package main.compiler.generator.expression;

import main.compiler.entity.expression.BoolExpression;
import main.compiler.entity.expression.Expression;
import main.compiler.entity.expression.NumberExpression;
import main.compiler.entity.expression.StringExpression;
import main.compiler.entity.value.Value;
import main.compiler.generator.Generator;

public class ExpressionGenerator extends Generator {

    private Expression expression;
    private Value value = null;
    private boolean boolContinue = false;

    public ExpressionGenerator(Expression expression) {
        this.expression = expression;
    }

    public void generate(int index) {
        if (expression instanceof NumberExpression) {
            this.value = (new NumberExpressionGenerator((NumberExpression) expression)).generate(index);
        } else if (expression instanceof BoolExpression) {
            this.boolContinue = (new BoolExpressionGenerator((BoolExpression) expression)).generate(index);
        } else if (expression instanceof StringExpression) {
            (new StringExpressionGenerator((StringExpression) expression)).generate(index);
        }
    }

    public void generate() {
        generate(0);
    }

    public Value getValue() {
        return value;
    }

    public boolean isBoolContinue() {
        return boolContinue;
    }
}
