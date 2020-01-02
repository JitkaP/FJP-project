package main.compiler.entity;

import java.util.HashMap;
import java.util.Stack;

/**
 * This class represents program.
 */
public class Program {

    //TODO: smazal bych
    private Stack<HashMap<String, Symbol>> symbolTableStack = new Stack<>();
    private Block block;

    public Program(Block block) {
        this.block = block;
    }

    public Block getBlock() {
        return block;
    }
}
