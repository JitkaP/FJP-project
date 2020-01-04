package main.compiler.generator.expression;

import main.compiler.ErrorHandler;
import main.compiler.entity.Variable;
import main.compiler.entity.expression.BoolExpression;
import main.compiler.entity.value.*;
import main.compiler.enums.EBoolOp;
import main.compiler.enums.EErrorType;
import main.compiler.enums.EInstruction;
import main.compiler.enums.EInstructionOpr;
import main.compiler.generator.Generator;

import java.util.List;

/**
 * Generator for bool expressions.
 */
public class BoolExpressionGenerator extends Generator {

    private BoolExpression boolExpression;

    private int index = -1;

    public BoolExpressionGenerator(BoolExpression boolExpression) {
        this.boolExpression = boolExpression;
    }

    /**
     * Method for processing and generating instructions of bool expression.
     * @param index index in array
     * @return true if array wasn't loaded whole (so this has to be called again)
     */
    public boolean generate(int index) {
        this.index = index;
        Object left = null;
        Object right;
        List<Object> tokens = this.boolExpression.getTokens();
        boolean result = false;

        if (tokens.size() == 1) {
            result = generateValue(tokens.get(0));
        }

        for (int i = 0; i < tokens.size(); i++) { // !, &&, ||, ident, bool_value
            Object token = tokens.get(i);

            if (token instanceof EBoolOp) {
                if (token == EBoolOp.NEG) {
                    if (left == null) {
                        left = tokens.get(i+1);
                        generateValue(left);
                    }

                    addInstruction(EInstruction.LIT, 0, 0);
                    addInstruction(EInstruction.OPR, 0, EInstructionOpr.EQUAL.getValue());
                } else if (token == EBoolOp.AND) {
                    if (left == null) {
                        left = tokens.get(i - 1);
                        generateValue(left);
                    }

                    right = tokens.get(i+1);
                    generateValue(right);

                    addInstruction(EInstruction.OPR, 0, EInstructionOpr.MULTIPLY.getValue());
                } else if (token == EBoolOp.OR) {
                    if (left == null) {
                        left = tokens.get(i - 1);
                        generateValue(left);
                    }

                    right = tokens.get(i+1);
                    generateValue(right);

                    addInstruction(EInstruction.OPR, 0, EInstructionOpr.PLUS.getValue());
                    addInstruction(EInstruction.LIT, 0, 0);
                    addInstruction(EInstruction.OPR, 0, EInstructionOpr.NOT_EQUAL.getValue());
                }
            }
        }

        return result;
    }

    /**
     * Generates value of given token. Returns if whole array wasn't loaded.
     * @param token token
     * @return true if whole array wasn't loaded (so this has to be called again)
     */
    private boolean generateValue(Object token) {
        boolean result = false;

        if (token instanceof BoolValue) {
            boolean b = ((BoolValue) token).getBool();
            int intValue = (b) ? 1 : 0; // 1=true, 0=false
            addInstruction(EInstruction.LIT, 0, intValue);
        } else if (token instanceof IdentValue) {
            IdentValue identValue = ((IdentValue) token);
            String name = identValue.getName();
            int address = getAddress(name);
            int level = getLevel(name);

            int length = getLength(name);
            int index = getIndex(identValue);

            Variable variable = getVariable(name);
            Value value = getVariableValue(name);
            if ((index < 0) && (value instanceof ArrayIntValue || value instanceof ArrayBoolValue || value instanceof ArrayCharValue)) { // whole array
                if (this.index < length) {
                    if (variable.isConst()) {
                        Value indexValue = getVariableValue(name, this.index);
                        addInstruction(EInstruction.LIT, 0, getInt(indexValue));
                    } else {
                        address += this.index;
                        addInstruction(EInstruction.LOD, level, address);
                    }
                }

                if (this.index < length - 1) {
                    result = true;
                }
            } else { // index
                if (index >= length) {
                    ErrorHandler.throwError(EErrorType.INDEX_OUT_OF_BOUNDS);
                }

                if (variable.isConst()) {
                    Value indexValue = getVariableValue(name, index);
                    addInstruction(EInstruction.LIT, 0, getInt(indexValue));
                } else {
                    if (index >= 0) {
                        address += index;
                    }
                    addInstruction(EInstruction.LOD, level, address);
                }
            }

        }

        return result;
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
