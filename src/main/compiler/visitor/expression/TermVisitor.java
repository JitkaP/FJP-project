package main.compiler.visitor.expression;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.expression.Factor;
import main.compiler.entity.expression.Term;
import main.compiler.enums.ENumberOp;

import java.util.ArrayList;
import java.util.List;

public class TermVisitor extends LangBaseVisitor<Term> {

    @Override
    public Term visitTerm(LangParser.TermContext ctx) {
        List<Object> tokens = new ArrayList<>();

        // options: *, /, factor
        for (int i = 0; i < ctx.children.size(); i++) {
            Object token;
            String s = ctx.children.get(i).getText();

            if (s.equals("*")) {
                token = ENumberOp.MUL;
            } else if (s.equals("/")) {
                token = ENumberOp.DIV;
            } else {
                token = new FactorVisitor().visitFactor((LangParser.FactorContext) ctx.children.get(i));
            }

            tokens.add(token);
        }

        return new Term(tokens);
    }
}
