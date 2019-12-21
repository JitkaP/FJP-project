package main.compiler.visitor.statement;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.statement.ReadStatement;

public class ReadStatementVisitor extends LangBaseVisitor<ReadStatement> {

    @Override
    public ReadStatement visitReadstmt(LangParser.ReadstmtContext ctx) {
        String name;

        if (ctx.ident() != null) {
            name = ctx.ident().getText();
            return new ReadStatement(name);
        } else {
            name = ctx.ident_arr().ident(0).getText();
            if (ctx.ident_arr().NUMBER() != null) {
                int index = Integer.parseInt(ctx.ident_arr().NUMBER().getText());
                return new ReadStatement(name, index);
            } else {
                String indexName = ctx.ident_arr().ident(1).getText();
                return new ReadStatement(name, indexName);
            }
        }
    }

}
