package main.compiler.visitor.statement;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.Variable;
import main.compiler.entity.expression.Expression;
import main.compiler.entity.statement.AssignmentStatement;
import main.compiler.visitor.expression.ExpressionVisitor;

import java.util.ArrayList;
import java.util.List;

public class AssignmentStatementVisitor extends LangBaseVisitor<AssignmentStatement> {

    @Override
    public AssignmentStatement visitAssignstmt(LangParser.AssignstmtContext ctx) {
        List<Variable> variables = new ArrayList<>();

        String exp = ctx.expression().getText();
        //System.out.println("exp = " + exp);

        List<LangParser.IdentContext> names = ctx.ident();
        for (LangParser.IdentContext identContext: names) {
            String name = identContext.getText();
            //System.out.println("name = " + name);

            // type je null, zde jen prirazujeme, v tabulce symbolu by ovsem tato promenna uz mela byt
            Variable variable = new Variable(name, exp, null, false);

            variables.add(variable);
        }

        return new AssignmentStatement(variables);
    }
}
