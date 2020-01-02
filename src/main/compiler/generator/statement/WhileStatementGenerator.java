package main.compiler.generator.statement;

import main.compiler.entity.statement.WhileStatement;
import main.compiler.enums.EInstruction;
import main.compiler.generator.ConditionGenerator;
import main.compiler.generator.Generator;

import java.util.LinkedList;
import java.util.List;

/**
 * Generator for while statements.
 */
public class WhileStatementGenerator extends Generator {

    private WhileStatement whileStatement;

    public WhileStatementGenerator(WhileStatement whileStatement) {
        this.whileStatement = whileStatement;
    }

    /**
     * Method for processing and generating instructions of while statement.
     */
    public void generate() {
        int startRow = getNumberOfInstructions();

        ConditionGenerator conditionGenerator;
        List<Integer> jmcRows = new LinkedList<>();

        int i = -1;
        do {
            conditionGenerator = new ConditionGenerator(whileStatement.getCondition());
            conditionGenerator.generate(i++);
            int jmcRow = getNumberOfInstructions();
            jmcRows.add(jmcRow);
            addInstruction(EInstruction.JMC, 0, -1);
            new StatementGenerator(whileStatement.getStatement()).generate();
        } while (conditionGenerator.isBoolContinue());

        addInstruction(EInstruction.JMP, 0, startRow);

        for (int jmcRow: jmcRows) {
            getInstructions().get(jmcRow).setData(getNumberOfInstructions());
        }
    }
}
