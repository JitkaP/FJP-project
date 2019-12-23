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

        new DeclarationGenerator().generate();
        new ProcedureGenerator().generate();
        new StatementGenerator(block.getStatement()).generate();

        addInstruction(EInstruction.RET, 0, 0);
    }
}
