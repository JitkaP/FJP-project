package main.compiler.visitor;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.Variable;
import main.compiler.enums.EVariableType;

public class DeclarationVisitor extends LangBaseVisitor<Variable> {

    @Override
    public Variable visitDeclaration(LangParser.DeclarationContext ctx) {
        Variable variable = null;

        // consts
        if (ctx.consts() != null && !ctx.consts().isEmpty()) {
            String name = ctx.consts().ident().getText();
            EVariableType type = EVariableType.valueOf(ctx.consts().TYPE().getText().toUpperCase());
            String valueString = ctx.consts().value().getText();

            variable = new Variable(name, valueString, type,true);

        // constarrays todo
        } else if (ctx.constarrays() != null && !ctx.constarrays().isEmpty()) {
            /*String name = ctx.vars().IDENT().getText();
            Value value = new Value(ctx.vars().VALUE().getText());
            variable =  new Variable(name, value, true); */

        // vars - todo arrays
        } else if (ctx.vars() != null && !ctx.vars().isEmpty()) {
            EVariableType type = EVariableType.valueOf(ctx.vars().TYPE().getText().toUpperCase());

            for (LangParser.IdentContext identContext : ctx.vars().ident()) {
                String name = identContext.getText();
                variable = new Variable(name, null, type,false);
            }
        }

        return variable;
    }

}
