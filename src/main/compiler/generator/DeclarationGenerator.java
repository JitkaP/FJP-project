package main.compiler.generator;

import main.compiler.entity.Symbol;
import main.compiler.entity.Variable;
import main.compiler.enums.EInstruction;

import java.util.HashMap;
import java.util.List;

public class DeclarationGenerator extends Generator {

    private static final int INT_OFFSET = 3;

    public void generate() {

        int counter = 0;

        List<HashMap<String, Symbol>> tables = getTables();
        int tablesSize = tables.size();

        for (Symbol symbol : tables.get(tablesSize - 1).values()) {
            if (symbol instanceof Variable && !((Variable) symbol).isConst()) {
                Variable variable = (Variable) symbol;
                variable.setAddress(getStackPointer());
                increaseStackPointer();
                counter++;
            }
        }

        addInstruction(EInstruction.INT, 0, (counter + INT_OFFSET));

    }
}
