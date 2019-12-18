package main.compiler.visitor.statement;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.statement.BeginStatement;

public class BeginStatementVisitor extends LangBaseVisitor<BeginStatement> {

    @Override
    public BeginStatement visitBeginstmt(LangParser.BeginstmtContext ctx) {
        return new BeginStatement(); // prozatim, aby slo prelozit
    }
}
