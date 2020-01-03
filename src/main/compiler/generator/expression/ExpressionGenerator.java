package main.compiler.generator.expression;

import main.compiler.entity.expression.BoolExpression;
import main.compiler.entity.expression.Expression;
import main.compiler.entity.expression.NumberExpression;
import main.compiler.entity.expression.StringExpression;
import main.compiler.entity.value.*;
import main.compiler.enums.EInstruction;
import main.compiler.generator.Generator;

import java.util.List;

/**
 * Generator for expressions.
 */
public class ExpressionGenerator extends Generator {

    private Expression expression;
    private Value value = null;
    private boolean boolContinue = false;

    public ExpressionGenerator(Expression expression) {
        this.expression = expression;
    }

    /**
     * Method for processing and generating instructions ???
     * @param index
     */
    public void generate(int index) {
        if (expression instanceof BoolExpression) {
            List<Object> tokens = ((BoolExpression) expression).getTokens();
            if (tokens.size() == 1) {
                Object object = tokens.get(0);
                if (object instanceof IdentValue) {
                    IdentValue identValue = (IdentValue) object;
                    String name = identValue.getName();

                    Value value = getVariableValue(name);
                    if (value instanceof ArrayIntValue || value instanceof ArrayBoolValue || value instanceof ArrayCharValue) {
                        int varIndex = getIndex(identValue);
                        this.value = getVariableValue(name, varIndex);

                        int length = getLength(name);

                        if (index < length) {
                            addInstruction(EInstruction.LOD, getLevel(name), getAddress(name) + index);
                            if (index < length - 1) {
                                this.boolContinue = true;
                            }
                        }
                    } else {
                        this.value = value;
                        addInstruction(EInstruction.LOD, getLevel(name), getAddress(name));
                    }

                    return;
                }
            }
        }

        if (expression instanceof NumberExpression) {
            this.value = (new NumberExpressionGenerator((NumberExpression) expression)).generate(index);
        } else if (expression instanceof BoolExpression) {
            this.boolContinue = (new BoolExpressionGenerator((BoolExpression) expression)).generate(index);
        } else if (expression instanceof StringExpression) {
            (new StringExpressionGenerator((StringExpression) expression)).generate();
        }
    }

    /**
     * ???
     */
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
