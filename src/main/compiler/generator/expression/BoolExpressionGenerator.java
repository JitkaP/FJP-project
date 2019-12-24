package main.compiler.generator.expression;

import main.compiler.entity.expression.BoolExpression;
import main.compiler.entity.value.BoolValue;
import main.compiler.entity.value.IdentValue;
import main.compiler.enums.EBoolOp;
import main.compiler.enums.EInstruction;
import main.compiler.enums.EInstructionOpr;
import main.compiler.generator.Generator;

import java.util.List;

public class BoolExpressionGenerator extends Generator {

    private BoolExpression boolExpression;

    public BoolExpressionGenerator(BoolExpression boolExpression) {
        this.boolExpression = boolExpression;
    }

    public void generate() {
        List<Object> tokens = this.boolExpression.getTokens();

        if (tokens.size() == 1) {
            generateValue(tokens.get(0));
        }

        for (int i = 0; i < tokens.size(); i++) { // !, &&, ||, ident, bool_value
            Object token = tokens.get(i);

            if (token instanceof EBoolOp) {
                if (token == EBoolOp.NEG) {
                    Object after = tokens.get(i+1);
                    generateValue(after);

                    addInstruction(EInstruction.LIT, 0, 0);
                    addInstruction(EInstruction.OPR, 0, EInstructionOpr.EQUAL.getValue());
                } else if (token == EBoolOp.AND) {
                    Object left = tokens.get(i-1);
                    generateValue(left);
                    Object right = tokens.get(i+1);
                    generateValue(right);

                    addInstruction(EInstruction.OPR, 0, EInstructionOpr.MULTIPLY.getValue());
                } else if (token == EBoolOp.OR) {
                    Object left = tokens.get(i-1);
                    generateValue(left);
                    Object right = tokens.get(i+1);
                    generateValue(right);

                    addInstruction(EInstruction.OPR, 0, EInstructionOpr.PLUS.getValue());
                    addInstruction(EInstruction.LIT, 0, 0);
                    addInstruction(EInstruction.OPR, 0, EInstructionOpr.NOT_EQUAL.getValue());
                }
            }
        }

        /*for (Object token: this.boolExpression.getTokens()) { // !, &&, ||, ident, bool_value
            if (token instanceof BoolValue) {
                boolean b = ((BoolValue) token).getBool();
                int intValue = (b) ? 1 : 0; // 1=true, 0=false
                addInstruction(EInstruction.LIT, 0, intValue);
            } else if (token instanceof IdentValue) {
                int address = getAddress(((IdentValue) token).getName());
                addInstruction(EInstruction.LIT, 0, address);
            } else if (token instanceof EBoolOp) {
                if (token == EBoolOp.NEG) {
                    addInstruction(EInstruction.LIT, 0, 0);
                    addInstruction(EInstruction.OPR, 0, EInstructionOpr.EQUAL.getValue());
                } else if (token == EBoolOp.AND) {
                    addInstruction(EInstruction.OPR, 0, EInstructionOpr.MULTIPLY.getValue());
                } else if (token == EBoolOp.OR) {
                    addInstruction(EInstruction.OPR, 0, EInstructionOpr.PLUS.getValue());
                    addInstruction(EInstruction.LIT, 0, 0);
                    addInstruction(EInstruction.OPR, 0, EInstructionOpr.NOT_EQUAL.getValue());
                }
            }
        } */
    }

    private void generateValue(Object token) {
        if (token instanceof BoolValue) {
            boolean b = ((BoolValue) token).getBool();
            int intValue = (b) ? 1 : 0; // 1=true, 0=false
            addInstruction(EInstruction.LIT, 0, intValue);
        } else if (token instanceof IdentValue) {
            String name = ((IdentValue) token).getName();
            int address = getAddress(name);
            int level = getLevel(name);
            addInstruction(EInstruction.LOD, level, address);
        }
    }
}
