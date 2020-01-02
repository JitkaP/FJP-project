package main.compiler.entity.value;

/**
 * This class represents boolean value.
 */
public class BoolValue extends Value {

    private boolean bool;

    public BoolValue(boolean bool) {
        this.bool = bool;
        setValue(bool);
    }

    public boolean getBool() {
        return bool;
    }
}
