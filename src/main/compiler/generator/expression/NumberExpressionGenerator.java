package main.compiler.generator.expression;

import main.compiler.entity.expression.Factor;
import main.compiler.entity.expression.NumberExpression;
import main.compiler.entity.expression.Term;
import main.compiler.entity.value.IdentValue;
import main.compiler.entity.value.IntValue;

import main.compiler.entity.value.Value;
import main.compiler.enums.EInstruction;
import main.compiler.enums.EInstructionOpr;
import main.compiler.enums.ENumberOp;
import main.compiler.generator.Generator;

import java.util.List;

public class NumberExpressionGenerator extends Generator {

    private NumberExpression numberExpression;
    private int index = -1;

    public NumberExpressionGenerator(NumberExpression numberExpression) {
        this.numberExpression = numberExpression;
    }

    public IntValue generate() {
        return generate(-1);
    }

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

    public IntValue factorGenerate(Factor factor) {
        // value - identvalue/intvalue, nebo numberexpression - todo numberexp
        Value value = factor.getValue();
        IntValue returnValue = null;

        if (value != null) {
            if (value instanceof IntValue) {
                addInstruction(EInstruction.LIT, 0, ((IntValue) value).getInteger());
                returnValue = (IntValue) value;
            } else if (value instanceof IdentValue) {
                String name = ((IdentValue) value).getName();
                int address = getAddress(name);
                int level = getLevel(name);

                int data = address;
                if (this.index > 0) {
                    data += index;
                }

                addInstruction(EInstruction.LOD, level, data);
                returnValue = (IntValue) getVariableValue(name, this.index); // todo - really?
            }
        } else if (factor.getNumberExpression() != null){
            NumberExpression numberExpression = factor.getNumberExpression();
            NumberExpressionGenerator generator = new NumberExpressionGenerator(numberExpression);
            returnValue = generator.generate(0);
        }
        return returnValue;
    }

}
