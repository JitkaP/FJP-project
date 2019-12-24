package main.compiler.generator.statement;

import main.compiler.entity.statement.*;
import main.compiler.enums.EInstruction;
import main.compiler.generator.Generator;
import main.compiler.visitor.statement.IfStatementVisitor;

import java.util.List;

public class StatementGenerator extends Generator {

    private Statement statement;

    public StatementGenerator(Statement statement) {
        this.statement = statement;
    }

    public void generate() {

        if (this.statement == null) {
            return;
        }

        switch (this.statement.getType()) {
            case BEGIN:
                new BeginStatementGenerator((BeginStatement) this.statement).generate();
                break;
            case ASSIGN:
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
            case READ:
                // todo
                break;
            case WRITE:
                // todo
                break;
            case TERNAR:
                // todo
                break;
        }
    }
}
