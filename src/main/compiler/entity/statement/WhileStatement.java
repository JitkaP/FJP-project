package main.compiler.entity.statement;

import main.compiler.entity.Condition;

/**
 * This class represents while statement.
 */
public class WhileStatement extends Statement {

    /**
     * Condition in WhileStatement
     */
    private Condition condition;

    /**
     * Statement in WhileStatement
     */
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
