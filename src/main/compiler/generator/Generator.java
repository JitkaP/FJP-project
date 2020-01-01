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

public abstract class Generator {

    private static List<Instruction> instructions = new ArrayList<>();

    private static int numberOfInstructions = 0;

    private static List<HashMap<String, Symbol>> tables = new ArrayList<>();

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

    public static int getAddress(String name) {
        for (HashMap<String, Symbol> table: tables) {
            if (table.get(name) != null) {
                return table.get(name).getAddress();
            }
        }

        throwError(EErrorType.VARIABLE_NOT_DECLARED, name);
        return -1;
    }

    protected static Value getVariableValue(String name) {
        return getVariableValue(name, -1);
    }

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

    public int getIndex(IdentValue identValue) {
        int index = -1;
        if (identValue.getIndexName() != null && !identValue.getIndexName().isEmpty()) {
            Value value = getVariableValue(identValue.getIndexName());
            if (value instanceof IntValue) {
                index = ((IntValue) value).getInteger();
            } else {
                // chyba (nejspis)
            }
        } else {
            index = identValue.getIndex();
        }

        return index;
    }

    public static int getLength(String name) {
        Variable variable = getVariable(name);

        int length = 0;
        if (variable.getLengthName() != null && !variable.getLengthName().isEmpty()) {
            Value value = getVariableValue(variable.getLengthName());
            if (value instanceof IntValue) {
                length = ((IntValue) value).getInteger();
            } else {
                // chyba (nejspis)
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

    protected static void throwError(EErrorType type, String name) {
        System.err.print("ERROR: " + type);
        System.err.println(" Variable name = \"" + name + "\".");
        System.exit(1);
    }
}
