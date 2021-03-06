package main.compiler.generator.expression;

import main.compiler.entity.Variable;
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
     * Generates instructions for given expression.
     * @param index index in array
     */
    public void generate(int index) {
        if (expression instanceof BoolExpression) {
            List<Object> tokens = ((BoolExpression) expression).getTokens();
            if (tokens.size() == 1) {
                Object object = tokens.get(0);
                if (object instanceof IdentValue) {
                    IdentValue identValue = (IdentValue) object;
                    String name = identValue.getName();

                    Variable variable = getVariable(name);
                    Value value = getVariableValue(name);
                    if (value instanceof ArrayIntValue || value instanceof ArrayBoolValue || value instanceof ArrayCharValue) {
                        int varIndex = getIndex(identValue);
                        this.value = getVariableValue(name, varIndex);

                        int length = getLength(name);

                        if (index < length) {
                            if (variable.isConst()) {
                                int number = getInt(this.value);
                                addInstruction(EInstruction.LIT, getLevel(name), number);
                            } else {
                                addInstruction(EInstruction.LOD, getLevel(name), getAddress(name) + index);
                            }

                            if (index < length - 1) {
                                this.boolContinue = true;
                            }
                        }
                    } else {
                        this.value = value;

                        if (variable.isConst()) {
                            addInstruction(EInstruction.LIT, getLevel(name), getInt(value));
                        } else {
                            addInstruction(EInstruction.LOD, getLevel(name), getAddress(name));
                        }
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
     * Generates instructions for given expression.
     */
    public void generate() {
        generate(0);
    }

    public Value getValue() {
        return value;
    }

    /**
     * Whether to call method for generating instructions again
     * - usually needed when working with arrays or in loops.
     * @return true if needed to call method {@link #generate()} again
     */
    public boolean isBoolContinue() {
        return boolContinue;
    }

    private int getInt(Value value) {
        int number = 0;
        if (value instanceof IntValue) {
            number = ((IntValue) value).getInteger();
        } else if (value instanceof BoolValue) {
            boolean b = ((BoolValue) value).getBool();
            number = (b) ? 1 : 0; // 1=true, 0=false
        } else if (value instanceof CharValue) {
            number = ((CharValue) value).getChar();
        }

        return number;
    }
}
