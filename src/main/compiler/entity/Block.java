package main.compiler.entity;

import java.util.HashMap;
import java.util.List;

public class Block {

    private List<Variable> variables;
    private List<Procedure> procedures;
    private List<Block> blocks;
    private Statement statement;
    //private HashMap<String, >

    public Block(List<Variable> variables, List<Procedure> procedures, List<Block> blocks, Statement statement) {
        this.variables = variables;
        this.procedures = procedures;
        this.blocks = blocks;
        this.statement = statement;
        addToHashMap();
    }

    private void addToHashMap() {

    }

    public List<Variable> getVariables() {
        return variables;
    }

    public List<Procedure> getProcedures() {
        return procedures;
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public Statement getStatement() {
        return statement;
    }
}
