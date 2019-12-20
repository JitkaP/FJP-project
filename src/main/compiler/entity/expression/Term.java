package main.compiler.entity.expression;

import java.util.List;

public class Term {

    private List<Object> tokens; // *, /, factor

    public Term(List<Object> tokens) {
        this.tokens = tokens;
    }

}
