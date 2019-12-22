package main.compiler.entity;

import java.util.HashMap;
import java.util.Stack;

public class Program {

    private Stack<HashMap<String, Symbol>> symbolTableStack = new Stack<>();
    private Block block;

    public Program(Block block) {
        this.block = block;
    }

    public Block getBlock() {
        return block;
    }

    public Stack<HashMap<String, Symbol>> getSymbolTableStack() {
        return symbolTableStack;
    }
}
