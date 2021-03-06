package main.compiler.entity.value;

/**
 * This class represents integer value.
 */
public class IntValue extends Value {

    private int integer;

    public IntValue(int integer) {
        this.integer = integer;
        setValue(integer);
    }

    public int getInteger() {
        return integer;
    }
}
