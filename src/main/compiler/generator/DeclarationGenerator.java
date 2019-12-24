package main.compiler.generator;

import main.compiler.entity.Symbol;
import main.compiler.entity.Variable;
import main.compiler.entity.value.IntValue;
import main.compiler.entity.value.Value;
import main.compiler.enums.EInstruction;

import java.util.HashMap;
import java.util.List;

public class DeclarationGenerator extends Generator {

    private static final int INT_OFFSET = 3;

    private int stackPointer = INT_OFFSET;

    public int generate() {

        int counter = 0;

        List<HashMap<String, Symbol>> tables = getTables();
        int tablesSize = tables.size();

        for (Symbol symbol : tables.get(tablesSize - 1).values()) {
            if (symbol instanceof Variable && !((Variable) symbol).isConst()) {
                Variable variable = (Variable) symbol;
                variable.setAddress(stackPointer);

                if (variable.getLengthName() != null && !variable.getLengthName().isEmpty()) {
                     Value value = getVariableValue(variable.getLengthName());
                     if (value instanceof IntValue) {
                         int length = ((IntValue) value).getInteger();
                         counter += length + 1;
                     } else {
                         // chyba (nejspis)
                     }
                } else {
                    counter += variable.getLength() + 1;
                    stackPointer += (variable.getLength() + 1);
                }
            }
        }

        //addInstruction(EInstruction.INT, 0, (counter + INT_OFFSET));
        return counter + INT_OFFSET;
    }
}
