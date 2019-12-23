package main.compiler.entity.statement;

import main.compiler.entity.Condition;

public class WhileStatement extends Statement {

    private Condition condition;
    private Statement statement;

    public WhileStatement(Condition condition, Statement statement) {
        this.condition = condition;
        this.statement = statement;
    }

    public Condition getCondition() {
        return condition;
    }

    public Statement getStatement() {
        return statement;
    }
}
