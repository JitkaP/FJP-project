package main.compiler.visitor.expression;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.expression.NumberExpression;
import main.compiler.entity.expression.Term;
import main.compiler.enums.ENumberOp;

import java.util.ArrayList;
import java.util.List;

public class NumberExpressionVisitor extends LangBaseVisitor<NumberExpression> {

    @Override
    public NumberExpression visitNumber_expression(LangParser.Number_expressionContext ctx) {
        List<Object> tokens = new ArrayList<>();

        // options: +, -, term
        for (int i = 0; i < ctx.children.size(); i++) {
            Object token;
            String s = ctx.children.get(i).getText();

            if (s.equals("+")) {
                token = ENumberOp.PLUS;
            } else if (s.equals("-")) {
                token = ENumberOp.MINUS;
            } else {
                token = new TermVisitor().visitTerm((LangParser.TermContext) ctx.children.get(i));
            }

            tokens.add(token);
        }

        return new NumberExpression(tokens);
    }
}
