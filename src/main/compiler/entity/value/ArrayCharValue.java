package main.compiler.entity.value;

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
