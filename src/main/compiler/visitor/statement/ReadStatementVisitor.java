package main.compiler.visitor.statement;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.statement.ReadStatement;

public class ReadStatementVisitor extends LangBaseVisitor<ReadStatement> {

    @Override
    public ReadStatement visitReadstmt(LangParser.ReadstmtContext ctx) {
        String name = ctx.ident().getText();
        return new ReadStatement(name);
    }

}
