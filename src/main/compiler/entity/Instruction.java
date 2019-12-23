package main.compiler.entity;

import main.compiler.enums.EInstruction;

public class Instruction {

    private int row;
    private EInstruction code;
    private int level;
    private int data;

    public Instruction(int row, EInstruction code, int level, int data) {
        this.row = row;
        this.code = code;
        this.level = level;
        this.data = data;
    }

    public int getData() {
        return data;
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
