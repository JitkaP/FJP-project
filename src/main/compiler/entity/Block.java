package main.compiler.entity;

import java.util.HashMap;
import java.util.List;

public class Block {

    private List<Variable> variables;
    private List<Procedure> procedures;
    //private List<Block> blocks;
    private Statement statement;
    private HashMap<String, Symbol> symbolTable = new HashMap<>();

    public Block(List<Variable> variables, List<Procedure> procedures, List<Block> blocks, Statement statement) {
        this.variables = variables;
        this.procedures = procedures;
        //this.blocks = blocks;
        this.statement = statement;
        addToHashMap(variables, procedures);
    }

    private void addToHashMap(List<Variable> variables, List<Procedure> procedures) {
        for (Symbol symbol: variables) {
            symbolTable.put(symbol.getName(), symbol);
        }

        for (Symbol symbol: procedures) {
            symbolTable.put(symbol.getName(), symbol);
        }
    }

    public HashMap<String, Symbol> getSymbolTable() {
        return symbolTable;
    }

    public List<Variable> getVariables() {
        return variables;
    }

    public List<Procedure> getProcedures() {
        return procedures;
    }

    /*public List<Block> getBlocks() {
        return blocks;
    }*/

    public Statement getStatement() {
        return statement;
    }
}
