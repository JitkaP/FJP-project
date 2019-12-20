package main.compiler.entity.expression;

import main.compiler.entity.value.Value;

import java.util.List;

public class StringExpression extends Expression {

    private List<Value> values; // idents and string_values, only need to concatenate

    public StringExpression(List<Value> values) {
        this.values = values;
    }

}
