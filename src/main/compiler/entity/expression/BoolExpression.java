package main.compiler.entity.expression;

import java.util.List;

public class BoolExpression extends Expression {

    private List<Object> tokens; // !, &&, ||, ident, bool_value

    public BoolExpression(List<Object> tokens) {
        this.tokens = tokens;
    }
}
