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
        Expression exp = new ExpressionVisitor().visit(ctx.expression());

        List<LangParser.IdentContext> names = ctx.ident();
        for (LangParser.IdentContext identContext: names) {
            String name = identContext.getText();

            Variable variable = new Variable(name, exp, null, false);
            variables.add(variable);
        }

        for (LangParser.Ident_arrContext ident_arrContext : ctx.ident_arr()) {
            String name = ident_arrContext.ident(0).getText();

            Variable variable;
            if (ident_arrContext.NUMBER() != null) {
                int index = Integer.parseInt(ident_arrContext.NUMBER().getText());
                variable = new Variable(name, exp, index, null, false);
            } else {
                String indexName = ident_arrContext.ident(0).getText();
                variable = new Variable(name, exp, indexName, null, false);
            }

            variables.add(variable);
        }

        // vsechny promenne maji type = null, zde jen prirazujeme (a nevime ani, do ceho),
        // ale v tabulce symbolu by ovsem tato promenna uz mela byt (vcetne toho typu)
        return new AssignmentStatement(variables);
    }
}
