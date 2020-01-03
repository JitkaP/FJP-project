package main.compiler.entity.expression;

import java.util.List;

/**
 * This class represents term.
 */
public class Term {

    /**
     * List of tokens.
     */
    private List<Object> tokens; // *, /, factor

    public Term(List<Object> tokens) {
        this.tokens = tokens;
    }

    public List<Object> getTokens() {
        return tokens;
    }
}
