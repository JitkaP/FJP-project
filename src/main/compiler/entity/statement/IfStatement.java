package main.compiler.entity.statement;

import main.compiler.entity.Condition;

public class IfStatement extends Statement {

    private Condition condition;
    private Statement ifStatement;
    private Statement elseStatement;

    public IfStatement(Condition condition, Statement ifStatement, Statement elseStatement) {
        this.condition = condition;
        this.ifStatement = ifStatement;
        this.elseStatement = elseStatement;
    }
}
