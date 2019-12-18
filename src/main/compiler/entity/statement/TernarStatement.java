package main.compiler.entity.statement;

import main.compiler.entity.Condition;
import main.compiler.entity.expression.Expression;

public class TernarStatement extends Statement {

    private String name;
    private Condition condition;
    private Expression leftExpression;
    private Expression rightExpression;

    public TernarStatement(String name, Condition condition, Expression leftExpression, Expression rightExpression) {
        this.name = name;
        this.condition = condition;
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
}
