package main.compiler.generator;

import main.compiler.entity.AssignVariable;
import main.compiler.entity.Variable;
import main.compiler.entity.statement.AssignmentStatement;
import main.compiler.entity.statement.BeginStatement;
import main.compiler.entity.statement.Statement;
import main.compiler.enums.EInstruction;

import java.util.List;

public class StatementGenerator extends Generator {

    private Statement statement;

    public StatementGenerator(Statement statement) {
        this.statement = statement;
    }

    public void generate() {

        if (statement instanceof BeginStatement) {
            List<Statement> statements = ((BeginStatement) statement).getStatements();
            for (Statement st: statements) {
                if (st instanceof AssignmentStatement) {
                    List<AssignVariable> variables = ((AssignmentStatement) st).getVariables();

                    for (AssignVariable variable: variables) {
                        Variable v = (Variable) symbolTable.get(variable.getName());
                        if (v != null) {
                            v.setValue(variable.getValue());

                            addInstruction(EInstruction.LIT, 0, v.getIntValue());
                            addInstruction(EInstruction.STO, 0, v.getAddress());

                        } else {
                            // vyjimka, ze se pouziva nedeklarovana promena
                        }
                    }

                }
            }
        }
        addInstruction(EInstruction.RET, 0, 0);

    }
}
