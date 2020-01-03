package main.compiler.entity;

import main.compiler.enums.EInstruction;

/**
 * This class represents instruction.
 */
public class Instruction {

    /**
     * Row of the instruction
     */
    private int row;

    /**
     * Instruction code
     */
    private EInstruction code;

    /**
     * Level in list of symbol tables
     */
    private int level;

    /**
     * Instruction data
     */
    private int data;

    public Instruction(int row, EInstruction code, int level, int data) {
        this.row = row;
        this.code = code;
        this.level = level;
        this.data = data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return  row + "  " +
                code + "   " +
                level + "   " +
                data + "\n";
    }
}
