package main.compiler.generator.statement;

import main.compiler.entity.statement.BeginStatement;
import main.compiler.entity.statement.Statement;
import main.compiler.generator.Generator;

import java.util.List;

public class BeginStatementGenerator extends Generator {

    private BeginStatement beginStatement;

    public BeginStatementGenerator(BeginStatement beginStatement) {
        this.beginStatement = beginStatement;
    }

    public void generate() {
        List<Statement> statements = this.beginStatement.getStatements();
        for (Statement statement: statements) {
            new StatementGenerator(statement).generate();
        }
    }

}
