package main.compiler.entity.expression;

import main.compiler.entity.value.ArrayCharValue;
import main.compiler.entity.value.CharValue;
import main.compiler.entity.value.IdentValue;
import main.compiler.entity.value.Value;
import main.compiler.enums.EInstruction;

import java.util.List;

public class StringExpression extends Expression {

    private List<Value> values; // idents and string_values, only need to concatenate

    public StringExpression(List<Value> values) {
        this.values = values;
    }

    public List<Value> getValues() {
        return values;
    }

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
