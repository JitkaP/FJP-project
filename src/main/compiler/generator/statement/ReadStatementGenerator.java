package main.compiler.generator.statement;

import main.compiler.entity.statement.ReadStatement;
import main.compiler.enums.EInstruction;
import main.compiler.generator.Generator;

public class ReadStatementGenerator extends Generator {

    private ReadStatement readStatement;

    public ReadStatementGenerator(ReadStatement readStatement) {
        this.readStatement = readStatement;
    }

    public void generate() {
        addInstruction(EInstruction.SIO, 0, 2);

        int identAddress = getAddress(readStatement.getName());

    }
}
