package main.compiler.generator.statement;

import main.compiler.entity.statement.WhileStatement;
import main.compiler.enums.EInstruction;
import main.compiler.generator.ConditionGenerator;
import main.compiler.generator.Generator;

public class WhileStatementGenerator extends Generator {

    private WhileStatement whileStatement;

    public WhileStatementGenerator(WhileStatement whileStatement) {
        this.whileStatement = whileStatement;
    }

    public void generate() {
        int startRow = getNumberOfInstructions();

        new ConditionGenerator(whileStatement.getCondition()).generate();

        int jmcRow = getNumberOfInstructions();

        addInstruction(EInstruction.JMC, 0 , -1);

        new StatementGenerator(whileStatement.getStatement()).generate();

        addInstruction(EInstruction.JMP, 0, startRow);

        getInstructions().get(jmcRow).setData(getNumberOfInstructions());
    }
}
