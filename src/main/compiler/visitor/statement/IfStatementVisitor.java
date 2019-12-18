package main.compiler.visitor.statement;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.statement.IfStatement;

public class IfStatementVisitor extends LangBaseVisitor<IfStatement> {

    @Override
    public IfStatement visitIfstmt(LangParser.IfstmtContext ctx) {
        return new IfStatement(); // prozatim, aby slo prelozit
    }

}
