package main.compiler.visitor.statement;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.AssignVariable;
import main.compiler.entity.Variable;
import main.compiler.entity.expression.Expression;
import main.compiler.entity.statement.AssignmentStatement;
import main.compiler.visitor.expression.ExpressionVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Visitor for AssignmentStatement class.
 */
public class AssignmentStatementVisitor extends LangBaseVisitor<AssignmentStatement> {

    /**
     * Method for visit AssignmentStatement
     * @param ctx context of the AssignmentStatement
     * @return object of the AssignmentStatement class
     */
    @Override
    public AssignmentStatement visitAssignstmt(LangParser.AssignstmtContext ctx) {
        List<AssignVariable> assignVariables = new ArrayList<>();
        Expression exp = new ExpressionVisitor().visit(ctx.expression());

        List<LangParser.IdentContext> names = ctx.ident();
        for (LangParser.IdentContext identContext: names) {
            String name = identContext.getText();

            AssignVariable variable = new AssignVariable(name, exp);
            assignVariables.add(variable);
        }

        for (LangParser.Ident_arrContext ident_arrContext : ctx.ident_arr()) {
            String name = ident_arrContext.ident(0).getText();

            AssignVariable variable;
            if (ident_arrContext.NUMBER() != null) {
                int index = Integer.parseInt(ident_arrContext.NUMBER().getText());
                variable = new AssignVariable(name, exp, index);
            } else {
                String indexName = ident_arrContext.ident(1).getText();
                variable = new AssignVariable(name, exp, indexName);
            }

            assignVariables.add(variable);
        }

        return new AssignmentStatement(assignVariables);
    }
}
