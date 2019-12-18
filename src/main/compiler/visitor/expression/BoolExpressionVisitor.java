package main.compiler.visitor.expression;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.expression.BoolExpression;

public class BoolExpressionVisitor extends LangBaseVisitor<BoolExpression> {

    @Override
    public BoolExpression visitBool_expression(LangParser.Bool_expressionContext ctx) {
        String result = "";

        for (int i = 0; i < ctx.children.size(); i++) { // example: ctx.children = [false, &&, !, true]
            String s = ctx.children.get(i).getText();
            result += s;
        }


        System.out.println("result = " + result);
        return new BoolExpression(result);
    }
}
