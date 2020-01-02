package main.compiler.entity.expression;

import main.compiler.entity.value.ArrayCharValue;
import main.compiler.entity.value.CharValue;
import main.compiler.entity.value.IdentValue;
import main.compiler.entity.value.Value;
import main.compiler.enums.EInstruction;

import java.util.List;

/**
 * This class represents string expression.
 */
public class StringExpression extends Expression {

    /**
     * List of values - idents and string values
     */
    private List<Value> values;

    public StringExpression(List<Value> values) {
        this.values = values;
    }

    public List<Value> getValues() {
        return values;
    }

    /**
     * Returns the length of the string.
     * @return length of the string
     */
    public int getLength() {
        int length = 0;

        for (Object token: this.getValues()) {
            if (token instanceof CharValue) {
                length++;
            } else if (token instanceof ArrayCharValue) {
                char[] array = ((ArrayCharValue) token).getArray();
                length += array.length;
            } else if (token instanceof IdentValue) {
                length++;
            }
        }

        return length;
    }

}
