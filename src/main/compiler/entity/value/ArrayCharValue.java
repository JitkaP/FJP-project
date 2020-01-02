package main.compiler.entity.value;

/**
 * This class represents array of character values (string).
 */
public class ArrayCharValue extends Value {

    private char[] array;

    public ArrayCharValue(char[] array) {
        this.array = array;
        setValue(array);
    }

    public char[] getArray() {
        return array;
    }
}
