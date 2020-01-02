package main.compiler.entity.statement;

import main.compiler.entity.Condition;

/**
 * This class represents if statement.
 */
public class IfStatement extends Statement {

    private Condition condition;
    private Statement ifStatement;
    private Statement elseStatement;

    public IfStatement(Condition condition, Statement ifStatement, Statement elseStatement) {
        this.condition = condition;
        this.ifStatement = ifStatement;
        this.elseStatement = elseStatement;
    }

    public Condition getCondition() {
        return condition;
    }

    public Statement getIfStatement() {
        return ifStatement;
    }

    public Statement getElseStatement() {
        return elseStatement;
    }
}
