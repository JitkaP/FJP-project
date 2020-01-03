package main.compiler.entity;

import main.compiler.entity.statement.Statement;

import java.util.HashMap;
import java.util.List;

/**
 * This class represents block.
 */
public class Block {

    /**
     * Statement in Block
     */
    private Statement statement;

    /**
     * Symbol table in Block
     */
    private HashMap<String, Symbol> symbolTable = new HashMap<>();

    public Block(List<Variable> variables, List<Procedure> procedures, Statement statement) {
        this.statement = statement;
        addToHashMap(variables, procedures);
    }

    /**
     * Adds variables and procedures to the symbol table.
     * @param variables list of variables
     * @param procedures list of procedures
     */
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

    public Statement getStatement() {
        return statement;
    }
}
