package main.compiler.enums;

public enum EErrorType {

    VARIABLE_NOT_DECLARED("Usage of not declared variable."),
    INCOMPATIBLE_TYPES("Incompatible types."),
    INDEX_OUT_OF_BOUNDS("Index is out of bounds.")
    ;

    private String message;

    EErrorType(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
