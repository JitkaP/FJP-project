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

public class NumberExpressionGenerator extends Generator {

    private NumberExpression numberExpression;

    public NumberExpressionGenerator(NumberExpression numberExpression) {
        this.numberExpression = numberExpression;
    }

    public void generate() {
        for (Object token: this.numberExpression.getTokens()) { // +, -, term
            if (token instanceof  ENumberOp) {
                if (token == ENumberOp.PLUS) {
                    addInstruction(EInstruction.OPR, 0, EInstructionOpr.PLUS.getValue());
                } else if (token == ENumberOp.MINUS) {
                    addInstruction(EInstruction.OPR, 0, EInstructionOpr.MINUS.getValue());
                }
            } else if (token instanceof Term) {
                termGenerate((Term) token);
            }
        }
    }

    public void termGenerate(Term term) {
        for (Object token: term.getTokens()) { // *, /, factor
            if (token instanceof ENumberOp) {
                if (token == ENumberOp.MUL) {
                    addInstruction(EInstruction.OPR, 0, EInstructionOpr.MULTIPLY.getValue());
                } else if (token == ENumberOp.DIV) {
                    addInstruction(EInstruction.OPR, 0, EInstructionOpr.DIVIDE.getValue());
                }
            } else if (token instanceof Factor) {
                factorGenerate((Factor) token);
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
                int address = getAddress(((IdentValue) value).getName());
                addInstruction(EInstruction.LIT, 0, address);
            }
        } else {
            NumberExpression numberExpression = factor.getNumberExpression();
            NumberExpressionGenerator generator = new NumberExpressionGenerator(numberExpression);
            generator.generate();
        }
    }

}
