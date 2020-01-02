package main.compiler.generator.statement;

import main.compiler.entity.statement.CallStatement;
import main.compiler.enums.EInstruction;
import main.compiler.generator.Generator;

/**
 * Generator for call statements.
 */
public class CallStatementGenerator extends Generator {

    private CallStatement callStatement;

    public CallStatementGenerator(CallStatement callStatement) {
        this.callStatement = callStatement;
    }

    /**
     * Method for processing and generating instructions of call statement.
     */
    public void generate() {
        String name = this.callStatement.getName();
        addInstruction(EInstruction.CAL, getLevel(name), getAddress(name));
    }
}
