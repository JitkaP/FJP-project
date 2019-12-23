package main.compiler.generator.statement;

import main.compiler.entity.AssignVariable;
import main.compiler.entity.statement.AssignmentStatement;
import main.compiler.enums.EInstruction;
import main.compiler.generator.Generator;
import main.compiler.generator.expression.ExpressionGenerator;

public class AssignmentStatementGenerator extends Generator {

    private AssignmentStatement assignmentStatement;

    public AssignmentStatementGenerator(AssignmentStatement assignmentStatement) {
        this.assignmentStatement = assignmentStatement;
    }

    public void generate() {
        for (AssignVariable assignVariable: this.assignmentStatement.getVariables()) {
            new ExpressionGenerator(assignVariable.getExpression()).generate();

            int address = getAddress(assignVariable.getName());
            addInstruction(EInstruction.STO, 0, address);
        }
    }

}
