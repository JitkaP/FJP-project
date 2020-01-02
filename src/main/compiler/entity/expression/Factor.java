package main.compiler.entity.expression;

import main.compiler.entity.value.Value;

/**
 * This class represents factor.
 */
public class Factor {

    // options:
    // 1) value - ident or number
    // 2) number expression

    /**
     * Value in Factor - identificator or number
     */
    private Value value = null;

    /**
     * Number expression in Factor
     */
    private NumberExpression numberExpression = null;

    public Factor(Value value) {
        this.value = value;
    }

    public Factor(NumberExpression numberExpression) {
        this.numberExpression = numberExpression;
    }

    public Value getValue() {
        return value;
    }

    public NumberExpression getNumberExpression() {
        return numberExpression;
    }
}
