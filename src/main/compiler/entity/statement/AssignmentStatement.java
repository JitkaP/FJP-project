package main.compiler.entity.statement;

import main.compiler.entity.AssignVariable;
import java.util.List;

/**
 * This class represents assignment statement.
 */
public class AssignmentStatement extends Statement {

    /**
     * List of assign variables
     */
    private List<AssignVariable> assignVariables;

    public AssignmentStatement(List<AssignVariable> assignVariables) {
        this.assignVariables = assignVariables;
    }

    public List<AssignVariable> getVariables() {
        return assignVariables;
    }
}
