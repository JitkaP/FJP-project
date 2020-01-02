package main.compiler.generator;

import main.compiler.entity.Symbol;
import main.compiler.entity.Variable;
import main.compiler.entity.value.IntValue;
import main.compiler.entity.value.Value;
import main.compiler.enums.EInstruction;

import java.util.HashMap;
import java.util.List;

/**
 * Generator for declarations.
 */
public class DeclarationGenerator extends Generator {

    private static final int INT_OFFSET = 3;

    private int stackPointer = INT_OFFSET;

    /**
     * Method for processing and generating instructions of declarations.
     * @return data for instruction INT - number of variables + offset
     */
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
                         variable.setValueWithLength(length);
                     } else {
                         //TODO: hodit vyjimku?
                         // chyba (nejspis)
                     }
                } else {
                    counter += variable.getLength() + 1;
                    stackPointer += (variable.getLength() + 1);
                }
            }
        }

        return counter + INT_OFFSET;
    }
}
