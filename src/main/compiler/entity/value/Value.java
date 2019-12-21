package main.compiler.entity.value;

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
        if (value == null) return ""; // asi jen docasne?

        return value.toString();
    }
}
