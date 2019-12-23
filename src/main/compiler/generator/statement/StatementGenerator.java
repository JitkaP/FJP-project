package main.compiler.generator.statement;

import main.compiler.entity.statement.AssignmentStatement;
import main.compiler.entity.statement.BeginStatement;
import main.compiler.entity.statement.Statement;
import main.compiler.enums.EInstruction;
import main.compiler.generator.Generator;

import java.util.List;

public class StatementGenerator extends Generator {

    private Statement statement;

    public StatementGenerator(Statement statement) {
        this.statement = statement;
    }

    public void generate() {
        switch (this.statement.getType()) {
            case BEGIN:
                new BeginStatementGenerator((BeginStatement) this.statement).generate();
                break;
            case ASSIGN:
                new AssignmentStatementGenerator((AssignmentStatement) this.statement).generate();
                break;
        }


        addInstruction(EInstruction.RET, 0, 0);

    }
}
