package main.compiler.generator.statement;

import main.compiler.entity.statement.DowhileStatement;
import main.compiler.enums.EInstruction;
import main.compiler.generator.ConditionGenerator;
import main.compiler.generator.Generator;

import java.util.LinkedList;
import java.util.List;

public class DowhileStatementGenerator extends Generator {

    private DowhileStatement dowhileStatement;

    public DowhileStatementGenerator(DowhileStatement dowhileStatement) {
        this.dowhileStatement = dowhileStatement;
    }

    public void generate() {
        int startRow = getNumberOfInstructions();

        new StatementGenerator(dowhileStatement.getStatement()).generate();

        ConditionGenerator conditionGenerator;
        List<Integer> jmcRows = new LinkedList<>();

        int i = -1;
        do {
            conditionGenerator = new ConditionGenerator(dowhileStatement.getCondition());
            conditionGenerator.generate(i++);
            int jmcRow = getNumberOfInstructions();
            jmcRows.add(jmcRow);
            addInstruction(EInstruction.JMC, 0, -1);
        } while (conditionGenerator.isBoolContinue());

        addInstruction(EInstruction.JMP, 0, startRow);

        for (int jmcRow: jmcRows) {
            getInstructions().get(jmcRow).setData(getNumberOfInstructions());
        }
    }
}
