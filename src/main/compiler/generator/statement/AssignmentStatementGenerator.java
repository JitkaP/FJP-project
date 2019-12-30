package main.compiler.generator.statement;

import main.compiler.entity.AssignVariable;
import main.compiler.entity.Variable;
import main.compiler.entity.statement.AssignmentStatement;
import main.compiler.entity.value.IntValue;
import main.compiler.entity.value.Value;
import main.compiler.enums.EInstruction;
import main.compiler.enums.EVariableType;
import main.compiler.generator.Generator;
import main.compiler.generator.expression.ExpressionGenerator;

public class AssignmentStatementGenerator extends Generator {

    private AssignmentStatement assignmentStatement;

    public AssignmentStatementGenerator(AssignmentStatement assignmentStatement) {
        this.assignmentStatement = assignmentStatement;
    }

    public void generate() {
        for (AssignVariable assignVariable: this.assignmentStatement.getVariables()) {
            Variable variable = getVariable(assignVariable.getName());

            int index = -1;
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

            EVariableType type = variable.getType();
            if (type == EVariableType.BOOL || type == EVariableType.CHAR || type == EVariableType.INT) {
                generateSimple(assignVariable, 0);
            } else { // arrays
                if (index > -1) { // assign to given index
                    generateSimple(assignVariable, index);
                } else { // assign to whole array
                    generateArray(assignVariable);
                }
            }
        }
    }

    private void generateArray(AssignVariable assignVariable) {
        Variable variable = getVariable(assignVariable.getName());
        int address = getAddress(assignVariable.getName());
        int level = getLevel(assignVariable.getName());
        int length = variable.getLength();

        // store length
        addInstruction(EInstruction.LIT, 0, length);
        addInstruction(EInstruction.STO, level, address - 1);

        for (int i = 0; i < length; i++) {
            int size = getInstructions().size();
            new ExpressionGenerator(assignVariable.getExpression()).generate(i);
            if (size < getInstructions().size()) {
                addInstruction(EInstruction.STO, level, address + i);
            }
        }
    }

    private void generateSimple(AssignVariable assignVariable, int index) {
        int size = getInstructions().size();
        ExpressionGenerator expressionGenerator = new ExpressionGenerator(assignVariable.getExpression());
        expressionGenerator.generate();
        Value value = expressionGenerator.getValue();
        int address = getAddress(assignVariable.getName());
        int level = getLevel(assignVariable.getName());

        if (size < getInstructions().size()) {
            addInstruction(EInstruction.STO, level, address + index);
            Variable variable = getVariable(assignVariable.getName());
            variable.setValue(value, index);
        }
    }

}
