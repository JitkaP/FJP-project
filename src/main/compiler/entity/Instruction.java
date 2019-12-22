package main.compiler.entity;

import main.compiler.enums.EInstruction;

public class Instruction {

    private EInstruction code;
    private int level;
    private int data;

    public Instruction(EInstruction code, int level, int data) {
        this.code = code;
        this.level = level;
        this.data = data;
    }

    @Override
    public String toString() {
        return code +
                "   " + level +
                "   " + data +
                "\n";
    }
}
