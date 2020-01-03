package main.compiler.entity;


/**
 * This class represents program.
 */
public class Program {

    private Block block;

    public Program(Block block) {
        this.block = block;
    }

    public Block getBlock() {
        return block;
    }
}
