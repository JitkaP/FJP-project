package main.compiler.generator;

import main.compiler.entity.*;
import main.compiler.enums.EInstruction;

public class ProgramGenerator extends Generator {

    private Program program;

    public ProgramGenerator(Program program) {
        this.program = program;
    }

    public void generate() {
        Block block = program.getBlock();

        new BlockGenerator(block).generate();
    }
}
