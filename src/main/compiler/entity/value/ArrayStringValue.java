package main.compiler.entity.value;

public class ArrayStringValue extends Value {

    private String[] array;

    public ArrayStringValue(String[] array) {
        this.array = array;
        setValue(array);
    }
}
