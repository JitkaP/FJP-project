package main.compiler.entity;

public class Value {

    private Object value;

    public Value(Object value) {
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
    }

    @Override
    public String toString() {
        return getStringValue();
    }
}
