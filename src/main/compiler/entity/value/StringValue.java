package main.compiler.entity.value;

public class StringValue extends Value {

    private String string;

    public StringValue(String string) {
        this.string = string;
        setValue(string);
    }

    public String getString() {
        return string;
    }
}
