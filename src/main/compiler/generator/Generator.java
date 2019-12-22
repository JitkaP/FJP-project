package main.compiler.generator;

import main.compiler.entity.Instruction;
import main.compiler.enums.EInstruction;

import java.util.ArrayList;
import java.util.List;

public abstract class Generator {

    private static List<Instruction> instructions = new ArrayList<>();

    private static int numberOfInstructions = 0;

    private static int stackPointer = 3;

    public static void addInstruction(EInstruction instruction, int level, int m) {
        instructions.add(new Instruction(instruction, level, m));
        numberOfInstructions++;
    }

    public static List<Instruction> getInstructions() {
        return instructions;
    }

    public static int getNumberOfInstructions() {
        return numberOfInstructions;
    }

    public static int getStackPointer() {
        return stackPointer;
    }

    public static void setStackPointer(int stackPointer) {
        Generator.stackPointer = stackPointer;
    }

    public static void increaseStackPointer() {
        stackPointer++;
    }
}
