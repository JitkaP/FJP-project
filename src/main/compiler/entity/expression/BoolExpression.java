package main.compiler.entity.expression;

import java.util.List;

/**
 * This class represents bool expression.
 */
public class BoolExpression extends Expression {

    /**
     * List of tokens
     */
    private List<Object> tokens; // !, &&, ||, ident, bool_value

    public BoolExpression(List<Object> tokens) {
        this.tokens = tokens;
    }

    public List<Object> getTokens() {
        return tokens;
    }
}
