package main.compiler.entity.statement;

import main.compiler.entity.Condition;
import main.compiler.entity.expression.Expression;

/**
 * This class represents ternar statement.
 */
public class TernarStatement extends Statement {

    /**
     * Name of the identificator
     */
    private String name;

    /**
     * Condition in TernarStatement
     */
    private Condition condition;

    /**
     * Left expression in TernarStatement
     */
    private Expression leftExpression;

    /**
     * Right expression in TernarStatement
     */
    private Expression rightExpression;

    /**
     * ???
     */
    private int index;

    /**
     * ???
     */
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

    public String getName() {
        return name;
    }

    public String getIndexName() {
        return indexName;
    }

    public int getIndex() {
        return index;
    }

    public Condition getCondition() {
        return condition;
    }

    public Expression getLeftExpression() {
        return leftExpression;
    }

    public Expression getRightExpression() {
        return rightExpression;
    }

}
