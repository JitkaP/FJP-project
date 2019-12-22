package main.compiler.entity;

import main.compiler.entity.expression.*;
import main.compiler.entity.value.BoolValue;
import main.compiler.entity.value.StringValue;
import main.compiler.entity.value.Value;

public class AssignVariable {

    private String name;
    private int index;
    private String indexName = null;

    private Value value;

    public AssignVariable(String name, Expression exp) {
        this.name = name;
        this.value = exp;
    }

    public AssignVariable(String name, Expression exp, int index) {
        this(name, exp);
        this.index = index;
    }

    public AssignVariable(String name, Expression exp, String indexName) {
        this(name, exp);
        this.indexName = indexName;
    }

    public String getName() {
        return name;
    }

    public Object getIndex() {
        if (indexName != null) return indexName;
        return index;
    }

    public Value getValue() {
        if (this.value instanceof NumberExpression) {
            Term t = (Term) ((NumberExpression) this.value).getTokens().get(0);
            Factor f = (Factor) t.getTokens().get(0);
            return f.getValue();
        } else if (this.value instanceof BoolExpression) {
            BoolValue boolValue = (BoolValue) ((BoolExpression) this.value).getTokens().get(0);
            return boolValue;
        } else if (this.value instanceof StringExpression) {
            StringValue stringValue = (StringValue) ((StringExpression) this.value).getValues().get(0);
            return stringValue;
        }
        return value;
    }
}
