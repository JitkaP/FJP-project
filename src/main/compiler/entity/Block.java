package main.compiler.entity;

import main.compiler.entity.statement.Statement;

import java.util.HashMap;
import java.util.List;

public class Block {

    private List<Variable> variables;
    private List<Procedure> procedures;
    private Statement statement;

    private HashMap<String, Symbol> symbolTable = new HashMap<>();

    public Block(List<Variable> variables, List<Procedure> procedures, Statement statement) {
        this.variables = variables;
        this.procedures = procedures;
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

    public Statement getStatement() {
        return statement;
    }
}
