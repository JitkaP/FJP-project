package main.compiler.visitor;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.Condition;
import main.compiler.entity.expression.BoolExpression;
import main.compiler.entity.expression.Expression;
import main.compiler.entity.expression.NumberExpression;
import main.compiler.enums.EConditionOperator;
import main.compiler.enums.EConditionType;
import main.compiler.visitor.expression.BoolExpressionVisitor;
import main.compiler.visitor.expression.ExpressionVisitor;
import main.compiler.visitor.expression.NumberExpressionVisitor;

public class ConditionVisitor extends LangBaseVisitor<Condition> {

    @Override
    public Condition visitCondition(LangParser.ConditionContext ctx) {

        if (ctx.number_expression() != null) {
            NumberExpression letfNumberExpression = new NumberExpressionVisitor().visit(ctx.number_expression(0));
            NumberExpression rightNumberExpression = new NumberExpressionVisitor().visit(ctx.number_expression(1));

            EConditionOperator operator = EConditionOperator.getSymbol(ctx.children.get(1).getText());

            return new Condition(letfNumberExpression, rightNumberExpression, operator, EConditionType.NUMBER);
        }
        else if (ctx.expression() != null) {
            Expression leftExpression = new ExpressionVisitor().visit(ctx.expression(0));
            Expression rightExpression = new ExpressionVisitor().visit(ctx.expression(1));

            EConditionOperator operator = EConditionOperator.getSymbol(ctx.children.get(1).getText());

            return new Condition(leftExpression, rightExpression, operator, EConditionType.GENERAL);
        }
        else if (ctx.bool_expression() != null) {
            BoolExpression boolExpression = new BoolExpressionVisitor().visit(ctx.bool_expression());

            return new Condition(boolExpression, EConditionType.BOOL);
        }
        else {
            return null; //pro test
        }
    }
}
