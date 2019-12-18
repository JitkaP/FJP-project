package main.compiler.visitor.statement;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.statement.WriteStatement;

public class WriteStatementVisitor extends LangBaseVisitor<WriteStatement> {

    @Override
    public WriteStatement visitWritestmt(LangParser.WritestmtContext ctx) {
        return new WriteStatement(); // prozatim, aby slo prelozit
    }

}
