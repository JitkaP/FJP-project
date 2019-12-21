package main.compiler.enums;

public enum EInstructionOpr {

    UN_MINUS(1),
    PLUS(2),
    MINUS(3),
    MULTIPLY(4),
    DIVIDE(5),
    MODULO(6),
    ODDNESS(7),
    EQUAL(8),
    NOT_EQUAL(9),
    LESS(10),
    GREATER_EQUAL(11),
    GREATER(12),
    LESS_EQUAL(13);

    private int value;

    EInstructionOpr(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
