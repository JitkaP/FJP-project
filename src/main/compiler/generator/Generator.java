package main.compiler.generator;

import main.compiler.entity.Instruction;
import main.compiler.entity.Symbol;
import main.compiler.entity.Variable;
import main.compiler.entity.value.Value;
import main.compiler.enums.EInstruction;
import main.compiler.enums.EVariableType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Generator {

    private static List<Instruction> instructions = new ArrayList<>();

    private static int numberOfInstructions = 0;

    private static int stackPointer = 3;

    private static List<HashMap<String, Symbol>> tables = new ArrayList<>();

    public static void addInstruction(EInstruction instruction, int level, int data) {
        instructions.add(new Instruction(getNumberOfInstructions(), instruction, level, data));
        numberOfInstructions++;
    }

    public static List<Instruction> getInstructions() {
        return instructions;
    }

    public static int getNumberOfInstructions() {
        return numberOfInstructions;
    }

    public static int getStackPointer() {
        return stackPointer;
    }

    public static void setStackPointer(int stackPointer) {
        Generator.stackPointer = stackPointer;
    }

    public static void increaseStackPointer(int value) {
        stackPointer += value;
    }

    public static void addSymbolTable(HashMap<String, Symbol> symbolTable) {
        tables.add(symbolTable);
    }

    public static Variable getVariable(String name) {
        for (HashMap<String, Symbol> table: tables) {
            if (table.get(name) != null) {
                Symbol symbol = table.get(name);
                if (symbol instanceof Variable) {
                    return (Variable) symbol;
                }
            }
        }

        return null; // todo - zde misto toho vyjimka
    }

    public static int getAddress(String name) {
        for (HashMap<String, Symbol> table: tables) {
            if (table.get(name) != null) {
                return table.get(name).getAddress();
            }
        }

        return -1; // todo - zde misto toho vyjimka
    }

    public static Value getVariableValue(String name) {
        for (HashMap<String, Symbol> table: tables) {
            if (table.get(name) != null) {
                Symbol symbol = table.get(name);
                if (symbol instanceof Variable) {
                    Variable variable = (Variable) symbol;
                    return variable.getValue();
                }
            }
        }

        return null; // todo - zde misto toho vyjimka
    }

    public static List<HashMap<String, Symbol>> getTables() {
        return tables;
    }
}
