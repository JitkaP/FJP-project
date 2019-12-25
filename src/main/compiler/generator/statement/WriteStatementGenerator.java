package main.compiler.generator.statement;

import main.compiler.entity.statement.WriteStatement;
import main.compiler.enums.EInstruction;
import main.compiler.generator.Generator;
import main.compiler.generator.expression.StringExpressionGenerator;

public class WriteStatementGenerator extends Generator {

    private WriteStatement writeStatement;

    public WriteStatementGenerator(WriteStatement writeStatement) {
        this.writeStatement = writeStatement;
    }

    public void generate() {
        new StringExpressionGenerator(writeStatement.getStringExpression());

        addInstruction(EInstruction.SIO, 0, 1);
    }
}
