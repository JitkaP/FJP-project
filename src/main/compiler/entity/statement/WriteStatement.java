package main.compiler.entity.statement;

import main.compiler.entity.expression.StringExpression;

public class WriteStatement extends Statement {

    private StringExpression stringExpression;

    public WriteStatement(StringExpression stringExpression) {
        this.stringExpression = stringExpression;
    }

    public StringExpression getStringExpression() {
        return stringExpression;
    }
}
