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
        int identAddress = getAddress(readStatement.getName());

        addInstruction(EInstruction.SIO, 0, 2);

        for (int i = 0; i < getVariable(readStatement.getName()).getLength(); i++) {

            if ()

            addInstruction(EInstruction.STO, 0, identAddress); // overeni, zda je spravny datovy typ..?

        }
    }
}
