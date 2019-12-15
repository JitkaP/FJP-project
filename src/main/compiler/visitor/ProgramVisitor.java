package main.compiler.visitor;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.Block;
import main.compiler.entity.Program;

public class ProgramVisitor extends LangBaseVisitor<Program> {

    @Override
    public Program visitProgram(LangParser.ProgramContext ctx) {
        Block programBlock = new BlockVisitor().visit(ctx.block());

        return new Program(programBlock);
    }
}
