package main.compiler.entity.statement;

import main.compiler.entity.Condition;
import main.compiler.entity.expression.Expression;

/**
 * This class represents ternary statement.
 */
public class TernarStatement extends Statement {

    /**
     * Name of the identificator of variable to assign to.
     */
    private String name;

    private Condition condition;
    private Expression leftExpression;
    private Expression rightExpression;

    /**
     * Index in array (if name represents identificator for array).
     */
    private int index;

    /**
     * Identificator of variable representing index in array (if name represents identificator for array).
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
