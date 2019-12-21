package main.compiler.entity;

import main.compiler.entity.expression.BoolExpression;
import main.compiler.entity.expression.Expression;
import main.compiler.entity.expression.NumberExpression;
import main.compiler.enums.EConditionOperator;
import main.compiler.enums.EConditionType;

public class Condition {

    private EConditionType type = null;
    private EConditionOperator operator = null;

    private NumberExpression leftNumberExpression = null;
    private NumberExpression rightNumberExpression = null;

    private Expression leftExpression = null;
    private Expression rightExpression = null;

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
