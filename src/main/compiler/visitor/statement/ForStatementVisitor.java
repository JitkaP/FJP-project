package main.compiler.visitor.statement;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.statement.ForStatement;

public class ForStatementVisitor extends LangBaseVisitor<ForStatement> {

    @Override
    public ForStatement visitForstmt(LangParser.ForstmtContext ctx) {
        return new ForStatement(); // prozatim, aby slo prelozit
    }

}
