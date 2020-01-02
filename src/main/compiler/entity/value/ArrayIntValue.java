package main.compiler.entity.value;

/**
 * This class represents array of integer values.
 */
public class ArrayIntValue extends Value {

    private int[] array;

    public ArrayIntValue(int[] array) {
        this.array = array;
        setValue(array);
    }

    public int[] getArray() {
        return array;
    }
}
