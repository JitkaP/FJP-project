package main.compiler.entity;

import main.compiler.entity.statement.Statement;

import java.util.HashMap;
import java.util.List;

/**
 * This class represents block.
 */
public class Block {

    /**
     * List of variables in Block
     */
    private List<Variable> variables;

    /**
     * List of procedures in Block
     */
    private List<Procedure> procedures;

    /**
     * Statement in Block
     */
    private Statement statement;

    /**
     * Symbol table in Block
     */
    private HashMap<String, Symbol> symbolTable = new HashMap<>();

    public Block(List<Variable> variables, List<Procedure> procedures, Statement statement) {
        this.variables = variables;
        this.procedures = procedures;
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

    public List<Variable> getVariables() {
        return variables;
    }

    public List<Procedure> getProcedures() {
        return procedures;
    }

    public Statement getStatement() {
        return statement;
    }
}
