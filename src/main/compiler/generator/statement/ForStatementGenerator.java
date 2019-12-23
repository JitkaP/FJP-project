package main.compiler.generator.statement;

import main.compiler.entity.statement.ForStatement;
import main.compiler.enums.EInstruction;
import main.compiler.enums.EInstructionOpr;
import main.compiler.generator.Generator;
import main.compiler.generator.expression.NumberExpressionGenerator;

public class ForStatementGenerator extends Generator {

    private ForStatement forStatement;

    public ForStatementGenerator(ForStatement forStatement) {
        this.forStatement = forStatement;
    }

    public void generate() {
        int identAddress = getAddress(forStatement.getName());

        new NumberExpressionGenerator(forStatement.getFrom()).generate();

        addInstruction(EInstruction.STO, 0, identAddress);

        int startRow = getNumberOfInstructions();
        addInstruction(EInstruction.LOD, 0, identAddress);

        new NumberExpressionGenerator(forStatement.getTo()).generate();
        addInstruction(EInstruction.OPR, 0, EInstructionOpr.LESS_EQUAL.getValue());

        int jmcRow = getNumberOfInstructions();
        addInstruction(EInstruction.JMC, 0, -1);

        new StatementGenerator(forStatement.getStatement()).generate();

        addInstruction(EInstruction.LOD, 0, identAddress);
        addInstruction(EInstruction.LIT, 0, 1);
        addInstruction(EInstruction.OPR, 0, EInstructionOpr.PLUS.getValue());
        addInstruction(EInstruction.STO, 0, identAddress);
        addInstruction(EInstruction.JMP, 0, startRow);

        getInstructions().get(jmcRow).setData(getNumberOfInstructions());
    }
}
