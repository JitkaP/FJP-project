package main.compiler.visitor;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.Block;
import main.compiler.entity.Program;
import main.compiler.entity.Statement;
import main.compiler.entity.Variable;

import java.util.List;

public class AssignmentStatementVisitor extends LangBaseVisitor<Variable> {

    @Override
    public Variable visitAssignstmt(LangParser.AssignstmtContext ctx) {
        List<LangParser.IdentContext> names = ctx.ident();
        for (LangParser.IdentContext identContext: names) {
            String name = identContext.getText();
            System.out.println("name = " + name);
        }

        String exp = ctx.expression().getText();
        System.out.println("exp = " + exp);

        //VariableType type = VariableType.valueOf(ctx.consts().TYPE().getText().toUpperCase());
        //Value value = new Value(ctx.consts().value().getText());

        return null;

        //Block programBlock = new BlockVisitor().visit(ctx.block());
        //return new Program(programBlock);
    }
}
