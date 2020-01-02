package main.compiler.entity.value;

/**
 * Abstract class represents value, extended by specific values classes.
 */
public abstract class Value {

    private Object value;

    public Object getValue() {
        return value;
    }

    protected void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if (value == null) return ""; // TODO: asi jen docasne?

        return value.toString();
    }
}
