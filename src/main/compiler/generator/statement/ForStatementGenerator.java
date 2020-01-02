package main.compiler.generator.statement;

import main.compiler.entity.AssignVariable;
import main.compiler.entity.expression.Factor;
import main.compiler.entity.expression.NumberExpression;
import main.compiler.entity.expression.Term;
import main.compiler.entity.statement.AssignmentStatement;
import main.compiler.entity.statement.ForStatement;
import main.compiler.entity.value.IdentValue;
import main.compiler.entity.value.IntValue;
import main.compiler.enums.*;
import main.compiler.generator.ConditionGenerator;
import main.compiler.generator.Generator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ForStatementGenerator extends Generator {

    private ForStatement forStatement;

    public ForStatementGenerator(ForStatement forStatement) {
        this.forStatement = forStatement;
    }

    public void generate() {
        NumberExpression expression = forStatement.getFrom();

        List<AssignVariable> assignVariableList = new LinkedList<>();
        AssignVariable assignVariable = new AssignVariable(forStatement.getName(), expression);
        assignVariableList.add(assignVariable);

        new AssignmentStatementGenerator(new AssignmentStatement(assignVariableList)).generate();

        int startRow = getNumberOfInstructions();

        ConditionGenerator conditionGenerator;
        List<Integer> jmcRows = new LinkedList<>();

        int i = -1;
        do {
            conditionGenerator = new ConditionGenerator(forStatement.getCondition());
            conditionGenerator.generate(i++);
            int jmcRow = getNumberOfInstructions();
            jmcRows.add(jmcRow);
            addInstruction(EInstruction.JMC, 0, -1);
            new StatementGenerator(forStatement.getStatement()).generate();

            // i+1
            List<AssignVariable> assignList = new LinkedList<>();
            List<Object> tokens = new LinkedList<>();
            IdentValue identValue = new IdentValue(forStatement.getName());

            List<Object> termObjects = new ArrayList<>();
            termObjects.add((new Factor(identValue)));
            tokens.add(new Term(termObjects));
            tokens.add(ENumberOp.PLUS);

            termObjects = new ArrayList<>();
            termObjects.add((new Factor(new IntValue(1))));
            tokens.add(new Term(termObjects));

            NumberExpression numberExpression = new NumberExpression(tokens);

            AssignVariable variable = new AssignVariable(forStatement.getName(), numberExpression);
            assignList.add(variable);
            AssignmentStatement assignmentStatement = new AssignmentStatement(assignList);
            assignmentStatement.setType(EStatementType.ASSIGN);

            new StatementGenerator(assignmentStatement).generate();

        } while (conditionGenerator.isBoolContinue());

        addInstruction(EInstruction.JMP, 0, startRow);

        for (int jmcRow: jmcRows) {
            getInstructions().get(jmcRow).setData(getNumberOfInstructions());
        }
    }
}
