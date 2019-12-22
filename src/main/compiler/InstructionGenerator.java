package main.compiler;

import main.compiler.entity.Instruction;
import main.compiler.entity.Program;
import main.compiler.generator.Generator;
import main.compiler.generator.ProgramGenerator;

import java.util.List;

public class InstructionGenerator {

    private Program program;

    public InstructionGenerator(Program program) {
        this.program = program;
    }

    public List<Instruction> generate() {
        ProgramGenerator programGenerator = new ProgramGenerator(program);
        programGenerator.generate();

        return Generator.getInstructions();
    }
}
