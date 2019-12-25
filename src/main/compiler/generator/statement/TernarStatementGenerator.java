package main.compiler.generator.statement;

import main.compiler.entity.AssignVariable;
import main.compiler.entity.Variable;
import main.compiler.entity.statement.*;
import main.compiler.enums.EStatementType;
import main.compiler.generator.Generator;

import java.util.ArrayList;
import java.util.List;

public class TernarStatementGenerator extends Generator {
    
    private TernarStatement ternarStatement;
    
    public TernarStatementGenerator(TernarStatement ternarStatement) {
        this.ternarStatement = ternarStatement;
    }
    
    public void generate() {
        Variable var = getVariable(ternarStatement.getName());

        String name = ternarStatement.getName();
        int index = ternarStatement.getIndex();
        String indexName = ternarStatement.getIndexName();

        AssignVariable left = new AssignVariable(name, ternarStatement.getLeftExpression(), index, indexName);
        List<AssignVariable> leftVar = new ArrayList<>();
        leftVar.add(left);
        AssignmentStatement leftAssign = new AssignmentStatement(leftVar);
        leftAssign.setType(EStatementType.ASSIGN);

        AssignVariable right = new AssignVariable(name, ternarStatement.getRightExpression(), index, indexName);
        List<AssignVariable> rigthVar = new ArrayList<>();
        rigthVar.add(right);
        AssignmentStatement rightAssign = new AssignmentStatement(rigthVar);
        rightAssign.setType(EStatementType.ASSIGN);

        IfStatement ifStatement = new IfStatement(ternarStatement.getCondition(), leftAssign, rightAssign);
        new IfStatementGenerator(ifStatement).generate();
    }
    
}
