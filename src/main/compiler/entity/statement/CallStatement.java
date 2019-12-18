package main.compiler.entity.statement;

public class CallStatement extends Statement {

    private String name;

    public CallStatement(String name) {
        this.name = name;
    }
}
