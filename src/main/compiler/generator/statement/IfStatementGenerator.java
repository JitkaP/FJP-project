package main.compiler.generator.statement;

import main.compiler.entity.statement.IfStatement;
import main.compiler.entity.statement.Statement;
import main.compiler.enums.EInstruction;
import main.compiler.generator.ConditionGenerator;
import main.compiler.generator.Generator;

public class IfStatementGenerator extends Generator {

    private IfStatement ifStatement;

    public IfStatementGenerator(IfStatement ifStatement) {
        this.ifStatement = ifStatement;
    }

    public void generate() {
        new ConditionGenerator(ifStatement.getCondition()).generate();

        int jmcRow = getNumberOfInstructions();

        addInstruction(EInstruction.JMC, 0, -1); // teď nevíme adresu skoku

        new StatementGenerator(ifStatement.getIfStatement()).generate();

        int jmpRow = getNumberOfInstructions();

        Statement elseStatement = ifStatement.getElseStatement();

        if (elseStatement != null) {
            addInstruction(EInstruction.JMP, 0, -1);
        }

        getInstructions().get(jmcRow).setData(getNumberOfInstructions());

        if (elseStatement != null) {
            new StatementGenerator(elseStatement).generate();
            getInstructions().get(jmpRow).setData(getNumberOfInstructions());
        }
    }
}
