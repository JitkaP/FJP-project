package main.compiler.entity.statement;

import main.compiler.entity.expression.NumberExpression;

public class ForStatement extends Statement {

    private String name;
    private NumberExpression from;
    private NumberExpression to;
    private Statement statement;

    public ForStatement(String name, NumberExpression from, NumberExpression to, Statement statement) {
        this.name = name;
        this.from = from;
        this.to = to;
        this.statement = statement;
    }

    public String getName() {
        return name;
    }

    public NumberExpression getFrom() {
        return from;
    }

    public NumberExpression getTo() {
        return to;
    }

    public Statement getStatement() {
        return statement;
    }
}
