package main.compiler.visitor.expression;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.expression.NumberExpression;

public class NumberExpressionVisitor extends LangBaseVisitor<NumberExpression> {

    @Override
    public NumberExpression visitNumber_expression(LangParser.Number_expressionContext ctx) {
        //Block programBlock = new BlockVisitor().visit(ctx.block());
        //return new Program(programBlock);
        return null;
    }
}
