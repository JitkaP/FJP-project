package main.compiler.enums;

public enum EConditionOperator {

    LESS("<"),
    LESS_EQ("<="),
    GREATER(">"),
    GREATER_EQ(">="),
    EQ("="),
    NOT_EQ("!=");

    private String value;

    EConditionOperator(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static EConditionOperator getSymbol(String value) {
        for (EConditionOperator e : EConditionOperator.values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        return null;
    }
}