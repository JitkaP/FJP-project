package main.compiler.entity;

import main.compiler.enums.EInstruction;

public class Instruction {

    private EInstruction code;
    private int level;
    private int m;

    public Instruction(EInstruction code, int level, int m) {
        this.code = code;
        this.level = level;
        this.m = m;
    }

    @Override
    public String toString() {
        return code +
                "   " + level +
                "   " + m +
                "\n";
    }
}
