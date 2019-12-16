package main.compiler.visitor;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.NumberExpression;

public class NumberExpressionVisitor extends LangBaseVisitor<NumberExpression> {

    @Override
    public NumberExpression visitNumber_expression(LangParser.Number_expressionContext ctx) {
        //Block programBlock = new BlockVisitor().visit(ctx.block());
        //return new Program(programBlock);
        return null;
    }
}
