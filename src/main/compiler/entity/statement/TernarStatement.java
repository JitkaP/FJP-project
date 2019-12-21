package main.compiler.entity.statement;

import main.compiler.entity.Condition;
import main.compiler.entity.expression.Expression;

public class TernarStatement extends Statement {

    private String name;
    private Condition condition;
    private Expression leftExpression;
    private Expression rightExpression;

    private int index;
    private String indexName;

    public TernarStatement(String name, Condition condition, Expression leftExpression, Expression rightExpression) {
        this.name = name;
        this.condition = condition;
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    public TernarStatement(String name, int index, Condition condition, Expression leftExpression, Expression rightExpression) {
        this(name, condition, leftExpression, rightExpression);
        this.index = index;
    }

    public TernarStatement(String name, String indexName, Condition condition, Expression leftExpression, Expression rightExpression) {
        this(name, condition, leftExpression, rightExpression);
        this.indexName = indexName;
    }
}
