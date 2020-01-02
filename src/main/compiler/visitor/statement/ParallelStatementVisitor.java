package main.compiler.visitor.statement;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.AssignVariable;
import main.compiler.entity.expression.Expression;
import main.compiler.entity.statement.AssignmentStatement;
import main.compiler.visitor.expression.ExpressionVisitor;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Visitor for ParallelStatement class.
 */
public class ParallelStatementVisitor extends LangBaseVisitor<AssignmentStatement> {

    /**
     * Method for visit ParallelStatement
     * @param ctx context of the ParallelStatement
     * @return object of AssignmentStatement class
     */
    @Override
    public AssignmentStatement visitParallelstmt(LangParser.ParallelstmtContext ctx) {

        List<AssignVariable> assignVariables = new ArrayList<>();

        List<Expression> expressions = new ArrayList<>();

        for (LangParser.ExpressionContext expressionContext: ctx.expression()) {
            Expression exp = new ExpressionVisitor().visit(expressionContext);
            expressions.add(exp);
        }

        int count = 0;
        for (int i = 0; i < ctx.children.size(); i++) {
            ParseTree tree = ctx.children.get(i);
            String name = tree.getText();

            if (tree instanceof LangParser.IdentContext) {
                AssignVariable variable = new AssignVariable(name, expressions.get(count++));
                assignVariables.add(variable);
            } else if (tree instanceof LangParser.Ident_arrContext) {
                AssignVariable variable;
                LangParser.Ident_arrContext ident_arrContext = (LangParser.Ident_arrContext) tree;
                if (ident_arrContext.NUMBER() != null) {
                    int index = Integer.parseInt(ident_arrContext.NUMBER().getText());
                    variable = new AssignVariable(name, expressions.get(count++), index);
                } else {
                    String indexName = ident_arrContext.ident(0).getText();
                    variable = new AssignVariable(name, expressions.get(count++), indexName);
                }

                assignVariables.add(variable);
            }
        }

        return new AssignmentStatement(assignVariables);
    }
}