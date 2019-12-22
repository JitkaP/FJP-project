package main.compiler.entity.statement;

import main.compiler.entity.AssignVariable;
import java.util.List;

public class AssignmentStatement extends Statement {

    private List<AssignVariable> assignVariables;

    public AssignmentStatement(List<AssignVariable> assignVariables) {
        this.assignVariables = assignVariables;
    }

    public List<AssignVariable> getVariables() {
        return assignVariables;
    }
}
