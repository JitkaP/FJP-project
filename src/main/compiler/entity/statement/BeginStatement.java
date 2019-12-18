package main.compiler.entity.statement;

import java.util.List;

public class BeginStatement extends Statement {

    List<Statement> statements;

    public BeginStatement(List<Statement> statements) {
        this.statements = statements;
    }

}
