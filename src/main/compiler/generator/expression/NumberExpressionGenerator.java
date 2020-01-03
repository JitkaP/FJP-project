package main.compiler.generator.expression;

import main.compiler.ErrorHandler;
import main.compiler.entity.Variable;
import main.compiler.entity.expression.Factor;
import main.compiler.entity.expression.NumberExpression;
import main.compiler.entity.expression.Term;
import main.compiler.entity.value.*;

import main.compiler.enums.EErrorType;
import main.compiler.enums.EInstruction;
import main.compiler.enums.EInstructionOpr;
import main.compiler.enums.ENumberOp;
import main.compiler.generator.Generator;

import java.util.List;

/**
 * Generator for number expressions.
 */
public class NumberExpressionGenerator extends Generator {

    private NumberExpression numberExpression;
    private int index = -1;

    public NumberExpressionGenerator(NumberExpression numberExpression) {
        this.numberExpression = numberExpression;
    }

    /**
     * Generates instructions for processing number expression.
     * @param index index in array
     * @return int value of whole evaluated expression
     */
    public IntValue generate(int index) {
        this.index = index;
        IntValue value = null;
        IntValue left = null;
        IntValue right = null;
        List<Object> tokens = this.numberExpression.getTokens();

        if (tokens.size() == 1) {
            value = termGenerate((Term) tokens.get(0));
        }

        for (int i = 0; i < tokens.size(); i++) {
            Object token = tokens.get(i);

            if (token instanceof  ENumberOp) {
                if (i == 0) {
                    if (token == ENumberOp.MINUS) {
                        IntValue intValue = termGenerate((Term) tokens.get(i+1));
                        addInstruction(EInstruction.OPR, 0, EInstructionOpr.UN_MINUS.getValue());
                        value = new IntValue(-1 * intValue.getInteger());
                    }
                } else {
                    if (left == null) {
                        left = termGenerate((Term) tokens.get(i - 1));
                    } else {
                        left = value;
                    }
                    right = termGenerate((Term) tokens.get(i + 1));
                    if (token == ENumberOp.PLUS) {
                        addInstruction(EInstruction.OPR, 0, EInstructionOpr.PLUS.getValue());
                        value = new IntValue(left.getInteger() + right.getInteger());
                    } else if (token == ENumberOp.MINUS) {
                        addInstruction(EInstruction.OPR, 0, EInstructionOpr.MINUS.getValue());
                        value = new IntValue(left.getInteger() - right.getInteger());
                    }
                }
            }
        }

        return value;
    }

    /**
     * Processes term and generates instructions.
     * @param term term
     * @return int value of evaluated term
     */
    public IntValue termGenerate(Term term) {
        IntValue value = null;
        IntValue left = null;
        IntValue right = null;
        List<Object> tokens = term.getTokens();

        if (tokens.size() == 1) {
            value = factorGenerate((Factor) tokens.get(0));
        }

        for (int i = 0; i < tokens.size(); i++) {
            Object token = tokens.get(i);
            if (token instanceof ENumberOp) {
                if (left == null) {
                    left = factorGenerate((Factor) tokens.get(i - 1));
                } else {
                    left = value;
                }
                right = factorGenerate((Factor) tokens.get(i+1));
                if (token == ENumberOp.MUL) {
                    addInstruction(EInstruction.OPR, 0, EInstructionOpr.MULTIPLY.getValue());
                    value = new IntValue(left.getInteger() * right.getInteger());
                } else if (token == ENumberOp.DIV) {
                    addInstruction(EInstruction.OPR, 0, EInstructionOpr.DIVIDE.getValue());
                    value = new IntValue(left.getInteger() / right.getInteger());
                }
            }
        }
        return value;
    }

    /**
     * Processes factor and generates instructions.
     * @param factor factor
     * @return int value of evaluated factor
     */
    public IntValue factorGenerate(Factor factor) {
        Value value = factor.getValue();
        IntValue returnValue = null;

        if (value != null) {
            if (value instanceof IntValue) {
                addInstruction(EInstruction.LIT, 0, ((IntValue) value).getInteger());
                returnValue = (IntValue) value;
            } else if (value instanceof IdentValue) {
                IdentValue identValue = (IdentValue) value;
                String name = identValue.getName();
                Variable variable = getVariable(name);
                Value variableValue = variable.getValue();

                int index = getIndex(identValue);

                if (variable.isConst()) {
                    if (variableValue instanceof IntValue) {
                        addInstruction(EInstruction.LIT, 0, ((IntValue) variableValue).getInteger());
                    }
                } else {

                    int address = getAddress(name);
                    int level = getLevel(name);

                    int data = address;
                    if (variableValue instanceof ArrayIntValue) {
                        if (this.index > 0) {
                            data += this.index;
                        } else if (index > 0) {
                            data += index;
                        }
                    }

                    addInstruction(EInstruction.LOD, level, data);
                }

                if (variableValue instanceof IntValue) {
                    returnValue = (IntValue) variableValue;
                } else if (variableValue instanceof ArrayIntValue && this.index >= 0) {
                    returnValue = new IntValue(((ArrayIntValue) variableValue).getArray()[this.index]);
                } else {
                    ErrorHandler.throwError(EErrorType.INCOMPATIBLE_TYPES);
                }
            }
        } else if (factor.getNumberExpression() != null){
            NumberExpression numberExpression = factor.getNumberExpression();
            NumberExpressionGenerator generator = new NumberExpressionGenerator(numberExpression);
            returnValue = generator.generate(0);
        }
        return returnValue;
    }

}
