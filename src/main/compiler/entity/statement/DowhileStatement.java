package main.compiler.entity.statement;

import main.compiler.entity.Condition;

/**
 * This class represents do while statement.
 */
public class DowhileStatement extends Statement {

    /**
     * Condition in DowhileStatement
     */
    private Condition condition;

    /**
     * Statement in DowhileStatement
     */
    private Statement statement;

    public DowhileStatement(Condition condition, Statement statement) {
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
