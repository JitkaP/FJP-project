package main.compiler.generator;

import main.compiler.entity.Block;
import main.compiler.enums.EInstruction;
import main.compiler.generator.statement.StatementGenerator;

public class BlockGenerator extends Generator {

    private Block block;

    public BlockGenerator(Block block) {
        this.block = block;
    }

    public void generate() {
        addSymbolTable(block.getSymbolTable());

        int jmcRow = getNumberOfInstructions();
        addInstruction(EInstruction.JMP, 0, -1);

        int intData = new DeclarationGenerator().generate();

        new ProcedureGenerator().generate();

        getInstructions().get(jmcRow).setData(getNumberOfInstructions());

        addInstruction(EInstruction.INT, 0, intData);

        new StatementGenerator(block.getStatement()).generate();

        removeLastTable();
        addInstruction(EInstruction.RET, 0, 0);
    }
}
