package main.compiler.entity.value;

public class CharValue extends Value {

    private char c;

    public CharValue(char c) {
        this.c = c;
        setValue(c);
    }

    public char getChar() {
        return c;
    }
}
