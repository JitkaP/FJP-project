package main.compiler.generator.statement;

import main.compiler.ErrorHandler;
import main.compiler.entity.AssignVariable;
import main.compiler.entity.Variable;
import main.compiler.entity.expression.BoolExpression;
import main.compiler.entity.expression.Expression;
import main.compiler.entity.expression.NumberExpression;
import main.compiler.entity.expression.StringExpression;
import main.compiler.entity.statement.AssignmentStatement;
import main.compiler.entity.value.IdentValue;
import main.compiler.entity.value.IntValue;
import main.compiler.entity.value.Value;
import main.compiler.enums.EErrorType;
import main.compiler.enums.EInstruction;
import main.compiler.enums.EVariableType;
import main.compiler.generator.Generator;
import main.compiler.generator.expression.ExpressionGenerator;

import java.util.List;

/**
 * Generator for assignment statements.
 */
public class AssignmentStatementGenerator extends Generator {

    private AssignmentStatement assignmentStatement;

    public AssignmentStatementGenerator(AssignmentStatement assignmentStatement) {
        this.assignmentStatement = assignmentStatement;
    }

    /**
     * Method for processing and generating instructions of assignment statements.
     */
    public void generate() {
        for (AssignVariable assignVariable: this.assignmentStatement.getVariables()) {
            Variable variable = getVariable(assignVariable.getName());

            int index = -1;
            if (assignVariable.getIndexName() != null && !assignVariable.getIndexName().isEmpty()) {
                Value value = getVariableValue(assignVariable.getIndexName());
                if (value instanceof IntValue) {
                    index = ((IntValue) value).getInteger();
                } else {
                    ErrorHandler.throwError(EErrorType.INCOMPATIBLE_TYPES, assignVariable.getIndexName());
                }
            } else {
                index = assignVariable.getIndex();
            }

            EVariableType type = variable.getType();
            typeCheck(assignVariable, type);
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

    /**
     * Method for processing and generating instructions of arrays in assignment statements.
     */
    private void generateArray(AssignVariable assignVariable) {
        Variable variable = getVariable(assignVariable.getName());
        int address = getAddress(assignVariable.getName());
        int level = getLevel(assignVariable.getName());
        int length = variable.getLength();

        // length instruction
        int row = getNumberOfInstructions();
        addInstruction(EInstruction.LIT, 0, -1); // length is not set here
        addInstruction(EInstruction.STO, level, address - 1);

        int actualLength = 0;
        int i;
        for (i = 0; i < length; i++) {
            int size = getInstructions().size();
            new ExpressionGenerator(assignVariable.getExpression()).generate(i);
            if (size < getInstructions().size()) {
                addInstruction(EInstruction.STO, level, address + i);
                actualLength++;
            }
        }

        getInstructions().get(row).setData(actualLength); // set length
    }

    /**
     * Method for checking assigning to correct data types.
     */
    private void typeCheck(AssignVariable assignVariable, EVariableType variableType) {
        boolean check = false;
        Expression expression = assignVariable.getExpression();

        if (expression instanceof BoolExpression) {
            List<Object> tokens = ((BoolExpression) expression).getTokens();
            if (tokens.size() == 1) {
                Object object = tokens.get(0);
                if (object instanceof IdentValue) {
                    return; // je to ok
                }
            }
        }

        if (variableType == EVariableType.INT || variableType == EVariableType.ARRAY_INT) {
            check = expression instanceof NumberExpression;
        } else if (variableType == EVariableType.BOOL || variableType == EVariableType.ARRAY_BOOL) {
            check = expression instanceof BoolExpression;
        } else if (variableType == EVariableType.CHAR || variableType == EVariableType.ARRAY_CHAR) {
            check = expression instanceof StringExpression;
        }

        if (!check) ErrorHandler.throwError(EErrorType.INCOMPATIBLE_TYPES, assignVariable.getName());
    }

    /**
     * Method for processing and generating instructions of non-arrays values in assignment statements.
     */
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

            int length = getLength(variable.getName());
            if (length > 0 && index >= length) {
                ErrorHandler.throwError(EErrorType.INDEX_OUT_OF_BOUNDS);
            }

            variable.setValue(value, index);
        }
    }

}
