package main.compiler.enums;

public enum EErrorType {

    VARIABLE_NOT_DECLARED("Usage of not declared variable."),
    INCOMPATIBLE_TYPES("Incompatible types when assigning.")
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
