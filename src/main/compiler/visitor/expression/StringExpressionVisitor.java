package main.compiler.visitor.expression;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.expression.StringExpression;
import main.compiler.entity.value.IdentValue;
import main.compiler.entity.value.StringValue;
import main.compiler.entity.value.Value;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class StringExpressionVisitor extends LangBaseVisitor<StringExpression> {

    @Override
    public StringExpression visitString_expression(LangParser.String_expressionContext ctx) {
        List<Value> values = new ArrayList<>();

        for (ParseTree child : ctx.children) {
            String s = child.getText();
            if (s.equals("+")) continue; // no need to store this char

            Value value;
            if (s.startsWith("\"")) {
                value = new StringValue(s);
            } else {
                value = new IdentValue(s);
            }

            values.add(value);
        }

        return new StringExpression(values);
    }
}
