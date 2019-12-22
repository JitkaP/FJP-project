package main.compiler.generator;

import main.compiler.entity.*;
import main.compiler.entity.statement.AssignmentStatement;
import main.compiler.entity.statement.BeginStatement;
import main.compiler.entity.statement.Statement;
import main.compiler.entity.value.Value;
import main.compiler.enums.EInstruction;
import main.compiler.enums.EVariableType;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProgramGenerator {

    private int stackPointer = 0;
    private Program program;

    public ProgramGenerator(Program program) {
        this.program = program;
    }

    public void generate() {
        List<Instruction> instructions = new ArrayList<>();

        Block block = this.program.getBlock();
        HashMap<String, Symbol> symbolTable = block.getSymbolTable();
        Statement statement = block.getStatement();

        this.program.getSymbolTableStack().push(symbolTable); // mozna treba takhle?

        // pokus o generovani instrukci
        instructions.add(new Instruction(EInstruction.JMP, 0, 1));
        stackPointer += 3;

        int counter = 0;
        for (Symbol symbol: symbolTable.values()) {
            if (symbol instanceof Variable && !((Variable) symbol).isConst()) {
                Variable variable = (Variable) symbol;
                variable.setAddress(stackPointer++);
                counter++;
            }
        }

        instructions.add(new Instruction(EInstruction.INT, 0, counter + 3));

        if (statement instanceof BeginStatement) {
            List<Statement> statements = ((BeginStatement) statement).getStatements();
            for (Statement st: statements) {
                if (st instanceof AssignmentStatement) {
                    List<AssignVariable> variables = ((AssignmentStatement) st).getVariables();

                    for (AssignVariable variable: variables) {
                        Variable v = (Variable) symbolTable.get(variable.getName());
                        if (v != null) {
                            v.setValue(variable.getValue());

                            instructions.add(new Instruction(EInstruction.LIT, 0, v.getIntValue()));
                            instructions.add(new Instruction(EInstruction.STO, 0, v.getAddress()));

                        } else {
                            // vyjimka, ze se pouziva nedeklarovana promena
                        }
                    }

                }
            }
        }

        instructions.add(new Instruction(EInstruction.RET, 0, 0));
        System.out.println(instructions.toString());
    }
}
