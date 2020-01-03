package main.compiler.enums;

/**
 * Error types with error messages.
 */
public enum EErrorType {

    VARIABLE_NOT_DECLARED("Usage of not declared variable."),
    INCOMPATIBLE_TYPES("Incompatible types."),
    INDEX_OUT_OF_BOUNDS("Index is out of bounds."),
    PROCEDURE_ALREADY_DECLARED("Declaring procedure with duplicate name in scope."),
    VARIABLE_ALREADY_DECLARED("Declaring variable with duplicate name in scope.")
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
