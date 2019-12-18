package main.compiler.entity.value;

public abstract class Value {

    private Object value;

    public Object getValue() {
        return value;
    }

    protected void setValue(Object value) {
        this.value = value;
    }

    /*public Value(Object value) {
        this.value = value;
    }

    public int getIntValue() {
        return Integer.parseInt(value.toString());
    }

    public String getStringValue() {
        return (String)value;
    }

    public boolean getBooleanValue() {
        return Boolean.parseBoolean(value.toString());
    } */

    @Override
    public String toString() {
        if (value == null) return ""; // asi jen docasne?

        return value.toString();
    }
}
