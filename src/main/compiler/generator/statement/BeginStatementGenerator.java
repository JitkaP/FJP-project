package main.compiler.generator.statement;

import main.compiler.entity.statement.BeginStatement;
import main.compiler.entity.statement.Statement;
import main.compiler.generator.Generator;

import java.util.List;

/**
 * Generator for begin statements.
 */
public class BeginStatementGenerator extends Generator {

    private BeginStatement beginStatement;

    public BeginStatementGenerator(BeginStatement beginStatement) {
        this.beginStatement = beginStatement;
    }

    /**
     * Method for processing and generating instructions of begin statement.
     */
    public void generate() {
        List<Statement> statements = this.beginStatement.getStatements();
        for (Statement statement: statements) {
            new StatementGenerator(statement).generate();
        }
    }

}
