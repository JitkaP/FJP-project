package main.compiler.visitor;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.Block;
import main.compiler.entity.Value;

import java.util.ArrayList;
import java.util.List;

public class BlockVisitor extends LangBaseVisitor<Block> {

    @Override
    public Block visitBlock(LangParser.BlockContext ctx) {
        List<Value> values = new ArrayList<>();
        Value value;

        for (LangParser.DeclarationContext declarationContext : ctx.declaration())
        {
            value = new DeclarationVisitor().visit(declarationContext);
            values.add(value);
        }

        return null;
    }
}
