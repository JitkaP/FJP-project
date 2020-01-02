package main.compiler.visitor;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.Block;
import main.compiler.entity.Procedure;

/**
 * Visitor for Procedure class.
 */
public class ProcedureVisitor extends LangBaseVisitor<Procedure> {

    /**
     * Method for visit Procedure
     * @param ctx context of the Procedure
     * @return object of Procedure class
     */
    @Override
    public Procedure visitProcedure(LangParser.ProcedureContext ctx) {
        Block block = new BlockVisitor().visit(ctx.block());
        String name = ctx.ident().getText();
        return new Procedure(name, block);
    }
}
