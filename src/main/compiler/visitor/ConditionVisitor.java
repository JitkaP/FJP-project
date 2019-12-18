package main.compiler.visitor;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.Condition;

public class ConditionVisitor extends LangBaseVisitor<Condition> {

    @Override
    public Condition visitCondition(LangParser.ConditionContext ctx) {


        return null;
    }
}
