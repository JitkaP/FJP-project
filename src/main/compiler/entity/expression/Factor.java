package main.compiler.entity.expression;

import main.compiler.entity.value.Value;

public class Factor {

    // options:
    // 1) value - ident or number
    // 2) number expression

    private Value value = null;
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
