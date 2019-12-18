package main.compiler.visitor.statement;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.statement.TernarStatement;

public class TernarStatementVisitor extends LangBaseVisitor<TernarStatement> {

    @Override
    public TernarStatement visitTernarstmt(LangParser.TernarstmtContext ctx) {
        return new TernarStatement(); // prozatim, aby slo prelozit
    }

}
