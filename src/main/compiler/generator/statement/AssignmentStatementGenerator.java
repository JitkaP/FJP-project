package main.compiler.generator.statement;

import main.compiler.entity.AssignVariable;
import main.compiler.entity.statement.AssignmentStatement;
import main.compiler.entity.value.IntValue;
import main.compiler.entity.value.Value;
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

            int index = 0;
            if (assignVariable.getIndexName() != null && !assignVariable.getIndexName().isEmpty()) {
                Value value = getVariableValue(assignVariable.getIndexName());
                if (value instanceof IntValue) {
                    index = ((IntValue) value).getInteger();
                } else {
                    // chyba (nejspis)
                }
            } else {
                index = assignVariable.getIndex();
            }

            int address = getAddress(assignVariable.getName());
            addInstruction(EInstruction.STO, 0, address + index);
        }
    }

}
