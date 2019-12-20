package main.compiler.entity.expression;

import java.util.List;

public class NumberExpression extends Expression {

    private List<Object> tokens; // +, -, term

    public NumberExpression(List<Object> tokens) {
        this.tokens = tokens;
    }
}
