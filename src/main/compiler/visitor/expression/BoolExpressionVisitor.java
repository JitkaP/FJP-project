package main.compiler.visitor.expression;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.expression.BoolExpression;
import main.compiler.entity.value.BoolValue;
import main.compiler.entity.value.IdentValue;
import main.compiler.enums.EBoolOp;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class BoolExpressionVisitor extends LangBaseVisitor<BoolExpression> {

    @Override
    public BoolExpression visitBool_expression(LangParser.Bool_expressionContext ctx) {
        List<Object> tokens = new ArrayList<>();

        // options: !, &&, ||, ident, bool_value
        for (int i = 0; i < ctx.children.size(); i++) {
            Object token;
            ParseTree tree = ctx.children.get(i);
            String s = tree.getText();

            if (s.equals("!")) {
                token = EBoolOp.NEG;
            } else if (s.equals("&&")) {
                token = EBoolOp.AND;
            } else if (s.equals("||")) {
                token = EBoolOp.OR;
            } else if (tree instanceof LangParser.IdentContext) {
                token = new IdentValue(tree.getText());
            } else if (tree instanceof LangParser.Ident_arrContext) {
                LangParser.Ident_arrContext arr_ctx = (LangParser.Ident_arrContext) tree;
                String name = arr_ctx.ident(0).getText();
                if (arr_ctx.NUMBER() != null) {
                    int index = Integer.parseInt(arr_ctx.NUMBER().getText());
                    token = new IdentValue(name, index);
                } else {
                    String indexName = arr_ctx.ident(1).getText();
                    token = new IdentValue(name, indexName);
                }
            }else { //if (tree instanceof TerminalNode) { // should be BOOLEAN
                token = new BoolValue(Boolean.parseBoolean(tree.getText()));
            }

            tokens.add(token);
        }

        return new BoolExpression(tokens);
    }
}
