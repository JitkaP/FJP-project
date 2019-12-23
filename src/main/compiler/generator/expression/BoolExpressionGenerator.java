package main.compiler.generator.expression;

import main.compiler.entity.expression.BoolExpression;
import main.compiler.entity.value.BoolValue;
import main.compiler.enums.EInstruction;
import main.compiler.generator.Generator;

public class BoolExpressionGenerator extends Generator {

    private BoolExpression boolExpression;

    public BoolExpressionGenerator(BoolExpression boolExpression) {
        this.boolExpression = boolExpression;
    }

    public void generate() {
        for (Object token: this.boolExpression.getTokens()) { // !, &&, ||, ident, bool_value
            if (token instanceof BoolValue) {
                boolean b = ((BoolValue) token).getBool();
                int intValue = (b) ? 1 : 0; // 1=true, 0=false
                addInstruction(EInstruction.LIT, 0, intValue);
            }
        }
    }
}
