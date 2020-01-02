package main.compiler.entity;

import main.compiler.entity.expression.BoolExpression;
import main.compiler.entity.expression.Expression;
import main.compiler.entity.expression.NumberExpression;
import main.compiler.enums.EConditionOperator;
import main.compiler.enums.EConditionType;

/**
 * This class represents condition.
 */
public class Condition {

    /**
     * Type of the Condition
     */
    private EConditionType type = null;

    /**
     * Operator in Condition
     */
    private EConditionOperator operator = null;

    /**
     * Left number expression
     */
    private NumberExpression leftNumberExpression = null;

    /**
     * Right number expression
     */
    private NumberExpression rightNumberExpression = null;

    /**
     * Left expression
     */
    private Expression leftExpression = null;

    /**
     * Right expression
     */
    private Expression rightExpression = null;

    /**
     * Bool expression
     */
    private BoolExpression boolExpression = null;

    public Condition(NumberExpression leftNumberExpression, NumberExpression rightNumberExpression, EConditionOperator operator, EConditionType type) {
        this.leftNumberExpression = leftNumberExpression;
        this.rightNumberExpression = rightNumberExpression;
        this.operator = operator;
        this.type = type;
    }

    public Condition(Expression leftExpression, Expression rightExpression, EConditionOperator operator, EConditionType type) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operator = operator;
        this.type = type;
    }

    public Condition(BoolExpression boolExpression, EConditionType type) {
        this.boolExpression = boolExpression;
        this.type = type;
    }

    public EConditionType getType() {
        return type;
    }

    public NumberExpression getLeftNumberExpression() {
        return leftNumberExpression;
    }

    public NumberExpression getRightNumberExpression() {
        return rightNumberExpression;
    }

    public Expression getLeftExpression() {
        return leftExpression;
    }

    public Expression getRightExpression() {
        return rightExpression;
    }

    public BoolExpression getBoolExpression() {
        return boolExpression;
    }

    public EConditionOperator getOperator() {
        return operator;
    }
}
