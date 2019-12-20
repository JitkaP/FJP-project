package main.compiler.entity.value;

public abstract class Value {

    private int length;
    private Object value;

    public Object getValue() {
        return value;
    }

    protected void setValue(Object value) {
        this.value = value;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        if (value == null) return ""; // asi jen docasne?

        return value.toString();
    }
}
