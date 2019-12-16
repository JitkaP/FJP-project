package main.compiler.visitor;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.Block;
import main.compiler.entity.Procedure;

public class ProcedureVisitor extends LangBaseVisitor<Procedure> {

    @Override
    public Procedure visitProcedure(LangParser.ProcedureContext ctx) {
        Block block = new BlockVisitor().visit(ctx.block());
        String name = ctx.ident().getText();
        return new Procedure(name, block);
    }
}
