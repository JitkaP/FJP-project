package main.compiler.visitor;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.List;

public class AssignmentStatementVisitor extends LangBaseVisitor<Variable> {

    @Override
    public Variable visitAssignstmt(LangParser.AssignstmtContext ctx) {
        List<LangParser.IdentContext> names = ctx.ident();
        for (LangParser.IdentContext identContext: names) {
            String name = identContext.getText();
            System.out.println("name = " + name);
        }

        String exp = ctx.expression().getText();
        System.out.println("exp = " + exp);

        LangParser.ExpressionContext expression = ctx.expression();
        if (expression.string_expression() != null) {
            StringExpression stringExpression = new StringExpressionVisitor().visit(ctx.expression().string_expression());
        } else if (expression.number_expression() != null) {
            NumberExpression numberExpression = new NumberExpressionVisitor().visit(expression.number_expression());
        } else if (expression.bool_expression() != null) {
            BoolExpression boolExpression = new BoolExpressionVisitor().visit(expression.bool_expression());
        }

        //VariableType type = VariableType.valueOf(ctx.consts().TYPE().getText().toUpperCase());
        //Value value = new Value(ctx.consts().value().getText());
        // todo - to variable

        return null;
    }
}
