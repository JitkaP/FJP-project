package main.compiler.entity.expression;

import java.util.List;

/**
 * This class represents number expression.
 */
public class NumberExpression extends Expression {

    /**
     * List of tokens
     */
    private List<Object> tokens; // +, -, term

    public NumberExpression(List<Object> tokens) {
        this.tokens = tokens;
    }

    public List<Object> getTokens() {
        return tokens;
    }
}
