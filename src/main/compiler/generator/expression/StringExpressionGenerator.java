package main.compiler.generator.expression;

import main.compiler.entity.expression.StringExpression;
import main.compiler.entity.value.ArrayCharValue;
import main.compiler.entity.value.IdentValue;
import main.compiler.entity.value.CharValue;
import main.compiler.enums.EInstruction;
import main.compiler.generator.Generator;

/**
 * Generator for string expressions.
 */
public class StringExpressionGenerator extends Generator {

    public StringExpression stringExpression;

    public StringExpressionGenerator(StringExpression stringExpression) {
        this.stringExpression = stringExpression;
    }

    /**
     * Method for processing and generating instructions of ???
     */
    public void generate(int index) {
        for (Object token: this.stringExpression.getValues()) { // idents and string_values, only need to concatenate
            if (token instanceof CharValue) {
                char c = ((CharValue) token).getChar();
                addInstruction(EInstruction.LIT, 0, c);
            } else if (token instanceof ArrayCharValue) {
                char[] array = ((ArrayCharValue) token).getArray();
                if (index < array.length) {
                    char c = array[index];
                    addInstruction(EInstruction.LIT, 0, c);
                }
            } else if (token instanceof IdentValue) {
                String name = ((IdentValue) token).getName();
                int address = getAddress(name);
                int level = getLevel(name);
                addInstruction(EInstruction.LOD, level, address);
            }
        }
    }

}
