package main.compiler.generator.statement;

import main.compiler.entity.statement.CallStatement;
import main.compiler.enums.EInstruction;
import main.compiler.generator.Generator;

public class CallStatementGenerator extends Generator {

    private CallStatement callStatement;

    public CallStatementGenerator(CallStatement callStatement) {
        this.callStatement = callStatement;
    }

    public void generate() {
        String name = this.callStatement.getName();
        addInstruction(EInstruction.CAL, 0, getAddress(name));
    }
}
