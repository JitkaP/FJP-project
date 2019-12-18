package main.compiler.visitor.statement;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.Condition;
import main.compiler.entity.expression.Expression;
import main.compiler.entity.statement.TernarStatement;
import main.compiler.visitor.ConditionVisitor;
import main.compiler.visitor.expression.ExpressionVisitor;

public class TernarStatementVisitor extends LangBaseVisitor<TernarStatement> {

    @Override
    public TernarStatement visitTernarstmt(LangParser.TernarstmtContext ctx) {
        String name = ctx.ident().getText();
        Condition condition = new ConditionVisitor().visit(ctx.condition());
        Expression leftExpression = new ExpressionVisitor().visit(ctx.expression(0));
        Expression rightExpression = new ExpressionVisitor().visit(ctx.expression(1));

        return new TernarStatement(name, condition, leftExpression, rightExpression);
    }

}
