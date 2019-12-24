package main.compiler.generator;

import main.compiler.entity.Procedure;
import main.compiler.entity.Symbol;

import java.util.HashMap;
import java.util.List;

public class ProcedureGenerator extends Generator {

    public void generate() {
        List<HashMap<String, Symbol>> tables = getTables();
        int tablesSize = tables.size();

        for (Symbol symbol : tables.get(tablesSize - 1).values()) {
            if (symbol instanceof Procedure) {
                Procedure procedure = (Procedure) symbol;
                procedure.setAddress(getNumberOfInstructions());
                new BlockGenerator(procedure.getBlock()).generate();
            }
        }
    }
}
