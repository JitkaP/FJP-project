package main.compiler.entity.statement;

import java.util.List;

/**
 * This class represents begin statement.
 */
public class BeginStatement extends Statement {

    /**
     * List of statements
     */
    List<Statement> statements;

    public BeginStatement(List<Statement> statements) {
        this.statements = statements;
    }

    public List<Statement> getStatements() {
        return statements;
    }
}
