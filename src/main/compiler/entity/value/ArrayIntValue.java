package main.compiler.entity.value;

public class ArrayIntValue extends Value {

    private int[] array;

    public ArrayIntValue(int[] array) {
        this.array = array;
        setValue(array);
    }

}
