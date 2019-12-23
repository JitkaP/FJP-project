package main.compiler.generator.expression;

import main.compiler.entity.expression.StringExpression;
import main.compiler.entity.value.IdentValue;
import main.compiler.entity.value.StringValue;
import main.compiler.enums.EInstruction;
import main.compiler.generator.Generator;

public class StringExpressionGenerator extends Generator {

    public StringExpression stringExpression;

    public StringExpressionGenerator(StringExpression stringExpression) {
        this.stringExpression = stringExpression;
    }

    public void generate() {
        for (Object token: this.stringExpression.getValues()) { // idents and string_values, only need to concatenate
            if (token instanceof StringValue) {
                char c = ((StringValue) token).getString().charAt(0); // todo!
                addInstruction(EInstruction.LIT, 0, c);
            } else if (token instanceof IdentValue) {
                int address = getAddress(((IdentValue) token).getName());
                addInstruction(EInstruction.LIT, 0, address);
            }
        }
    }

}
