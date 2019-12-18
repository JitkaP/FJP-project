package main.compiler.entity.statement;

import main.compiler.entity.Variable;
import java.util.List;

public class AssignmentStatement extends Statement {

    private List<Variable> variables;

    public AssignmentStatement(List<Variable> variables) {
        this.variables = variables;
    }

}
