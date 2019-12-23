package main.compiler.generator.statement;

import main.compiler.entity.statement.DowhileStatement;
import main.compiler.enums.EInstruction;
import main.compiler.generator.ConditionGenerator;
import main.compiler.generator.Generator;

public class DowhileStatementGenerator extends Generator {

    private DowhileStatement dowhileStatement;

    public DowhileStatementGenerator(DowhileStatement dowhileStatement) {
        this.dowhileStatement = dowhileStatement;
    }

    public void generate() {
        int startRow = getNumberOfInstructions();

        new StatementGenerator(dowhileStatement.getStatement()).generate();
        new ConditionGenerator(dowhileStatement.getCondition()).generate();

        int jmcRow = getNumberOfInstructions();

        addInstruction(EInstruction.JMC, 0, -1);
        addInstruction(EInstruction.JMP, 0, startRow);

        getInstructions().get(jmcRow).setData(getNumberOfInstructions());
    }
}
