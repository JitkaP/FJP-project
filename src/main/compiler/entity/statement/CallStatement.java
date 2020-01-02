package main.compiler.entity.statement;

/**
 * This class represents call statement
 */
public class CallStatement extends Statement {

    /**
     * Name of the procedure identificator
     */
    private String name;

    public CallStatement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
