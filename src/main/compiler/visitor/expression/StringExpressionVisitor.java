package main.compiler.visitor.expression;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.expression.StringExpression;
import org.antlr.v4.runtime.tree.ParseTree;

public class StringExpressionVisitor extends LangBaseVisitor<StringExpression> {

    @Override
    public StringExpression visitString_expression(LangParser.String_expressionContext ctx) {
        String result = "";

        // todo -> v := "aaa" + s + "bbb" (with ident)
        for (ParseTree child : ctx.children) { // example: ctx.children = ["aaa", +, "bbb", +, "ccc"]
            String s = child.getText();
            if (s.equals("+")) continue;

            s = s.replace("\"", ""); // todo not replace if inside string
            result += s;
        }

        //System.out.println("result = " + result);
        return new StringExpression(result);
    }
}
