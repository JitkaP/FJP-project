package main.compiler.generator.statement;

import main.compiler.entity.statement.*;
import main.compiler.enums.EInstruction;
import main.compiler.generator.Generator;
import main.compiler.visitor.statement.IfStatementVisitor;

import java.util.List;

/**
 * Generator for statements.
 */
public class StatementGenerator extends Generator {

    private Statement statement;

    public StatementGenerator(Statement statement) {
        this.statement = statement;
    }

    /**
     * Method for processing and generating instructions of statement.
     */
    public void generate() {

        if (this.statement == null) {
            return;
        }

        switch (this.statement.getType()) {
            case BEGIN:
                new BeginStatementGenerator((BeginStatement) this.statement).generate();
                break;
            case ASSIGN:
            case PARALLEL:
                new AssignmentStatementGenerator((AssignmentStatement) this.statement).generate();
                break;
            case IF:
                new IfStatementGenerator((IfStatement) this.statement).generate();
                break;
            case WHILE:
                new WhileStatementGenerator((WhileStatement) this.statement).generate();
                break;
            case DOWHILE:
                new DowhileStatementGenerator((DowhileStatement) this.statement).generate();
                break;
            case FOR:
                new ForStatementGenerator((ForStatement) this.statement).generate();
                break;
            case CALL:
                new CallStatementGenerator((CallStatement) this.statement).generate();
                break;
            case TERNAR:
                new TernarStatementGenerator((TernarStatement) this.statement).generate();
                break;
        }
    }
}
