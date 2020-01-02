package main.compiler.generator.expression;

import main.compiler.entity.expression.BoolExpression;
import main.compiler.entity.expression.Expression;
import main.compiler.entity.expression.NumberExpression;
import main.compiler.entity.expression.StringExpression;
import main.compiler.entity.value.IdentValue;
import main.compiler.entity.value.Value;
import main.compiler.enums.EInstruction;
import main.compiler.generator.Generator;

import java.util.List;

public class ExpressionGenerator extends Generator {

    private Expression expression;
    private Value value = null;
    private boolean boolContinue = false;

    public ExpressionGenerator(Expression expression) {
        this.expression = expression;
    }

    public void generate(int index) {
        if (expression instanceof BoolExpression) {
            List<Object> tokens = ((BoolExpression) expression).getTokens();
            if (tokens.size() == 1) {
                Object object = tokens.get(0);
                if (object instanceof IdentValue) {
                    IdentValue identValue = (IdentValue) object;
                    String name = identValue.getName();
                    this.value = getVariableValue(name);
                    //int index = getIndex(identValue);
                    addInstruction(EInstruction.LOD, getLevel(name), getAddress(name) + index);
                    return; // je to ok
                }
            }
        }

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
