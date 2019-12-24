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

    public NumberExpressionGenerator(NumberExpression numberExpression) {
        this.numberExpression = numberExpression;
    }

    public void generate() {
        List<Object> tokens = this.numberExpression.getTokens();

        if (tokens.size() == 1) {
            termGenerate((Term) tokens.get(0));
        }

        for (int i = 0; i < tokens.size(); i++) {
            Object token = tokens.get(i);

            if (token instanceof  ENumberOp) {
                if (i == 0) {
                    if (token == ENumberOp.MINUS) {
                        termGenerate((Term) tokens.get(i+1));
                        addInstruction(EInstruction.OPR, 0, EInstructionOpr.UN_MINUS.getValue());
                    }
                } else {
                    termGenerate((Term) tokens.get(i - 1));
                    termGenerate((Term) tokens.get(i + 1));
                    if (token == ENumberOp.PLUS) {
                        addInstruction(EInstruction.OPR, 0, EInstructionOpr.PLUS.getValue());
                    } else if (token == ENumberOp.MINUS) {
                        addInstruction(EInstruction.OPR, 0, EInstructionOpr.MINUS.getValue());
                    }
                }
            }
        }
    }

    public void termGenerate(Term term) {
        List<Object> tokens = term.getTokens();

        if (tokens.size() == 1) {
            factorGenerate((Factor) tokens.get(0));
        }

        for (int i = 0; i < tokens.size(); i++) {
            Object token = tokens.get(i);
            if (token instanceof ENumberOp) {
                factorGenerate((Factor) tokens.get(i-1));
                factorGenerate((Factor) tokens.get(i+1));
                if (token == ENumberOp.MUL) {
                    addInstruction(EInstruction.OPR, 0, EInstructionOpr.MULTIPLY.getValue());
                } else if (token == ENumberOp.DIV) {
                    addInstruction(EInstruction.OPR, 0, EInstructionOpr.DIVIDE.getValue());
                }
            }
        }
    }

    public void factorGenerate(Factor factor) {
        // value - identvalue/intvalue, nebo numberexpression - todo numberexp
        Value value = factor.getValue();

        if (value != null) {
            if (value instanceof IntValue) {
                addInstruction(EInstruction.LIT, 0, ((IntValue) value).getInteger());
            } else if (value instanceof IdentValue) {
                String name = ((IdentValue) value).getName();
                int address = getAddress(name);
                int level = getLevel(name);
                addInstruction(EInstruction.LOD, level, address);
            }
        } else if (factor.getNumberExpression() != null){
            NumberExpression numberExpression = factor.getNumberExpression();
            NumberExpressionGenerator generator = new NumberExpressionGenerator(numberExpression);
            generator.generate();
        }
    }

}
