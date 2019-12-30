package main.compiler.entity.value;

public class ArrayBoolValue extends Value {

    private boolean[] array;

    public ArrayBoolValue(boolean[] array) {
        this.array = array;
        setValue(array);
    }

    public boolean[] getArray() {
        return array;
    }
}
