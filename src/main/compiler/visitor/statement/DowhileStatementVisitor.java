package main.compiler.visitor.statement;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.statement.DowhileStatement;

public class DowhileStatementVisitor extends LangBaseVisitor<DowhileStatement> {

    @Override
    public DowhileStatement visitDowhilestmt(LangParser.DowhilestmtContext ctx) {
        return new DowhileStatement(); // prozatim, aby slo prelozit
    }

}
