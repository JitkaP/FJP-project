package main.compiler.generator;

import main.compiler.entity.*;

/**
 * Generator for program.
 */
public class ProgramGenerator extends Generator {

    private Program program;

    public ProgramGenerator(Program program) {
        this.program = program;
    }

    /**
     * Method for processing and generating instructions of program.
     */
    public void generate() {
        Block block = program.getBlock();

        new BlockGenerator(block).generate();
    }
}
