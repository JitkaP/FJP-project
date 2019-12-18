package main.compiler.visitor.statement;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.statement.WhileStatement;

public class WhileStatementVisitor extends LangBaseVisitor<WhileStatement> {

    @Override
    public WhileStatement visitWhilestmt(LangParser.WhilestmtContext ctx) {
        return new WhileStatement(); // prozatim, aby slo prelozit
    }

}
