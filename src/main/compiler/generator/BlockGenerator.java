package main.compiler.generator;

import main.compiler.entity.AssignVariable;
import main.compiler.entity.Block;
import main.compiler.entity.Variable;
import main.compiler.entity.statement.AssignmentStatement;
import main.compiler.entity.statement.BeginStatement;
import main.compiler.entity.statement.Statement;
import main.compiler.enums.EInstruction;
import java.util.List;

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

    }
}
