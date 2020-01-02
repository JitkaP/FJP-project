package main.compiler.visitor;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.Block;
import main.compiler.entity.Program;

/**
 * Visitor for Program class.
 */
public class ProgramVisitor extends LangBaseVisitor<Program> {

    /**
     * Method for visit Program
     * @param ctx context of the Program
     * @return object of Program class
     */
    @Override
    public Program visitProgram(LangParser.ProgramContext ctx) {
        Block programBlock = new BlockVisitor().visit(ctx.block());

        return new Program(programBlock);
    }
}
