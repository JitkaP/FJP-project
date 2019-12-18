package main.compiler.visitor;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.expression.BoolExpression;
import main.compiler.entity.expression.Expression;
import main.compiler.entity.expression.NumberExpression;
import main.compiler.entity.expression.StringExpression;
import main.compiler.visitor.expression.BoolExpressionVisitor;
import main.compiler.visitor.expression.ExpressionVisitor;
import main.compiler.visitor.expression.NumberExpressionVisitor;
import main.compiler.visitor.expression.StringExpressionVisitor;

import java.util.List;

public class AssignmentStatementVisitor extends LangBaseVisitor<Expression> {

    @Override
    public Expression visitAssignstmt(LangParser.AssignstmtContext ctx) {
        List<LangParser.IdentContext> names = ctx.ident();
        for (LangParser.IdentContext identContext: names) {
            String name = identContext.getText();
            System.out.println("name = " + name);
        }

        String exp = ctx.expression().getText();
        System.out.println("exp = " + exp);

        return new ExpressionVisitor().visit(ctx.expression());
    }
}
