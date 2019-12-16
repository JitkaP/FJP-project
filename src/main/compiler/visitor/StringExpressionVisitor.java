package main.compiler.visitor;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.NumberExpression;
import main.compiler.entity.StringExpression;

public class StringExpressionVisitor extends LangBaseVisitor<StringExpression> {

    @Override
    public StringExpression visitString_expression(LangParser.String_expressionContext ctx) {
        //Block programBlock = new BlockVisitor().visit(ctx.block());
        //return new Program(programBlock);

        System.out.println("ctx.children = " + ctx.children.toString());

        ctx.ident();
        ctx.STRING_VALUE();
        return null;
    }
}
