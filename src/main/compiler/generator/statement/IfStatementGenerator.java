package main.compiler.generator.statement;

import main.compiler.entity.statement.IfStatement;
import main.compiler.entity.statement.Statement;
import main.compiler.enums.EInstruction;
import main.compiler.generator.ConditionGenerator;
import main.compiler.generator.Generator;

import java.util.LinkedList;
import java.util.List;

public class IfStatementGenerator extends Generator {

    private IfStatement ifStatement;

    public IfStatementGenerator(IfStatement ifStatement) {
        this.ifStatement = ifStatement;
    }

    public void generate() {
        ConditionGenerator conditionGenerator;
        List<Integer> jmcRows = new LinkedList<>();

        int i = -1;
        do {
            conditionGenerator = new ConditionGenerator(ifStatement.getCondition());
            conditionGenerator.generate(i++);
            int jmcRow = getNumberOfInstructions();
            jmcRows.add(jmcRow);
            addInstruction(EInstruction.JMC, 0, -1);
        } while (conditionGenerator.isBoolContinue());

        new StatementGenerator(ifStatement.getIfStatement()).generate();

        int jmpRow = getNumberOfInstructions();

        Statement elseStatement = ifStatement.getElseStatement();

        if (elseStatement != null) {
            addInstruction(EInstruction.JMP, 0, -1);
        }

        for (int jmcRow: jmcRows) {
            getInstructions().get(jmcRow).setData(getNumberOfInstructions());
        }

        if (elseStatement != null) {
            new StatementGenerator(elseStatement).generate();
            getInstructions().get(jmpRow).setData(getNumberOfInstructions());
        }
    }
}
