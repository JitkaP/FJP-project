package main.compiler.generator;

import main.compiler.entity.Instruction;
import main.compiler.entity.Symbol;
import main.compiler.entity.Variable;
import main.compiler.entity.value.IdentValue;
import main.compiler.entity.value.IntValue;
import main.compiler.entity.value.Value;
import main.compiler.enums.EErrorType;
import main.compiler.enums.EInstruction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Abstract class, this class is extended by all '_Generator' classes.
 */
public abstract class Generator {

    /**
     * List of instructions
     */
    private static List<Instruction> instructions = new ArrayList<>();

    /**
     * Number of instructions - instruction counter
     */
    private static int numberOfInstructions = 0;

    /**
     * List of all symbol tables
     */
    private static List<HashMap<String, Symbol>> tables = new ArrayList<>();

    /**
     * Adds new instruction to the list of instructions
     * @param instruction new instruction
     * @param level level of the symbol table in stack
     * @param data data of the new instruction
     */
    public static void addInstruction(EInstruction instruction, int level, int data) {
        instructions.add(new Instruction(getNumberOfInstructions(), instruction, level, data));
        numberOfInstructions++;
    }

    public static List<Instruction> getInstructions() {
        return instructions;
    }

    protected static int getNumberOfInstructions() {
        return numberOfInstructions;
    }

    static void addSymbolTable(HashMap<String, Symbol> symbolTable) {
        tables.add(symbolTable);
    }

    static void removeLastTable() {
        tables.remove(tables.size() - 1);
    }

    /**
     * Finds instance of Variable class by name and returns it
     * @param name name of the Variable
     * @return instance of Variable
     */
    protected static Variable getVariable(String name) {
        for (HashMap<String, Symbol> table: tables) {
            if (table.get(name) != null) {
                Symbol symbol = table.get(name);
                if (symbol instanceof Variable) {
                    return (Variable) symbol;
                }
            }
        }

        throwError(EErrorType.VARIABLE_NOT_DECLARED, name);
        return null;
    }

    /**
     * Finds level of the Symbol in the symbol table by name and returns it.
     * @param name name of the Symbol
     * @return level of the Symbol
     */
    protected static int getLevel(String name) {
        int count = 0;
        for (int i = tables.size() - 1; i >= 0; i--) {
            HashMap<String, Symbol> table = tables.get(i);
            if (table.get(name) != null) {
                return count;
            }

            count++;
        }

        throwError(EErrorType.VARIABLE_NOT_DECLARED, name);
        return -1;
    }

    /**
     * Finds address of the Symbol in the symbol table by name and returns it.
     * @param name name of the Symbol
     * @return address of the Symbol
     */
    public static int getAddress(String name) {
        for (HashMap<String, Symbol> table: tables) {
            if (table.get(name) != null) {
                return table.get(name).getAddress();
            }
        }

        throwError(EErrorType.VARIABLE_NOT_DECLARED, name);
        return -1;
    }

    /**
     * Finds value of the Variable by name and returns it.
     * @param name name of the Variable
     * @return value of the Variable
     */
    protected static Value getVariableValue(String name) {
        return getVariableValue(name, -1);
    }

    /**
     * Finds value of the Variable by name and index and returns it.
     * @param name name of the Variable
     * @param index index of the symbol table
     * @return value of the Variable
     */
    protected static Value getVariableValue(String name, int index) {
        for (HashMap<String, Symbol> table: tables) {
            if (table.get(name) != null) {
                Symbol symbol = table.get(name);
                if (symbol instanceof Variable) {
                    Variable variable = (Variable) symbol;
                    return variable.getValue(index);
                }
            }
        }

        throwError(EErrorType.VARIABLE_NOT_DECLARED, name);
        return null;
    }

    static List<HashMap<String, Symbol>> getTables() {
        return tables;
    }

    /**
     * Finds index of the IdentValue and returns it. Useful mainly for arrays.
     * @param identValue instance of identValue
     * @return index of the input instance
     */
    public int getIndex(IdentValue identValue) {
        int index = -1;
        if (identValue.getIndexName() != null && !identValue.getIndexName().isEmpty()) {
            Value value = getVariableValue(identValue.getIndexName());
            if (value instanceof IntValue) {
                index = ((IntValue) value).getInteger();
            } else {
                throwError(EErrorType.INCOMPATIBLE_TYPES, identValue.getIndexName());
            }
        } else {
            index = identValue.getIndex();
        }

        return index;
    }

    /**
     * Finds length of the Variable and returns it. Useful for arrays.
     * @param name name of the Variable
     * @return length of the Variable
     */
    public static int getLength(String name) {
        Variable variable = getVariable(name);

        int length = 0;
        if (variable.getLengthName() != null && !variable.getLengthName().isEmpty()) {
            Value value = getVariableValue(variable.getLengthName());
            if (value instanceof IntValue) {
                length = ((IntValue) value).getInteger();
            } else {
                throwError(EErrorType.INCOMPATIBLE_TYPES, variable.getLengthName());
            }
        } else {
            length = variable.getLength();
        }

        return length;
    }

    public static void throwError(EErrorType type) {
        System.err.println(type);
        System.exit(1);
    }
    //TODO: tohle tu má bejt?
    protected static void throwError(EErrorType type, String name) {
        System.err.print("ERROR: " + type);
        System.err.println(" Variable name = \"" + name + "\".");
        System.exit(1);
    }
}
