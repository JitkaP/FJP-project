package main.compiler.visitor;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.BoolExpression;

public class BoolExpressionVisitor extends LangBaseVisitor<BoolExpression> {

    @Override
    public BoolExpression visitBool_expression(LangParser.Bool_expressionContext ctx) {
        //Block programBlock = new BlockVisitor().visit(ctx.block());
        //return new Program(programBlock);
        return null;
    }
}
