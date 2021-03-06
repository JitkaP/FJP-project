package main.compiler.visitor.expression;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.expression.StringExpression;
import main.compiler.entity.value.ArrayCharValue;
import main.compiler.entity.value.IdentValue;
import main.compiler.entity.value.CharValue;
import main.compiler.entity.value.Value;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Visitor for StringExpression class.
 */
public class StringExpressionVisitor extends LangBaseVisitor<StringExpression> {

    /**
     * Method for visit StringExpression
     * @param ctx context of the StringExpression
     * @return object of StringExpression class
     */
    @Override
    public StringExpression visitString_expression(LangParser.String_expressionContext ctx) {
        List<Value> values = new ArrayList<>();

        for (ParseTree child : ctx.children) {
            String s = child.getText();
            if (s.equals("+")) continue; // no need to store this char

            Value value;
            if (s.startsWith("\"")) {
                s = s.replace("\"", "");
                value = new ArrayCharValue(s.toCharArray());
            } else {
                value = new IdentValue(s);
            }

            values.add(value);
        }

        return new StringExpression(values);
    }
}
