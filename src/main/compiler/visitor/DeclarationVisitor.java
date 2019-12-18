package main.compiler.visitor;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.Value;
import main.compiler.entity.Variable;
import main.compiler.enums.EVariableType;

public class DeclarationVisitor extends LangBaseVisitor<Variable> {

    @Override
    public Variable visitDeclaration(LangParser.DeclarationContext ctx) {

        /*System.out.println("Typ: " + ctx.consts().TYPE().getText());
        System.out.println("Identifikator: " + ctx.consts().IDENT().getText());
        System.out.println("Hodnota: " + ctx.consts().VALUE().getText()); */

        Variable variable = null;

        // consts
        if (ctx.consts() != null && !ctx.consts().isEmpty()) {
            String name = ctx.consts().ident().getText();
            EVariableType type = EVariableType.valueOf(ctx.consts().TYPE().getText().toUpperCase());
            Value value = new Value(ctx.consts().value().getText());

            variable = new Variable(name, type,true);
            variable.setValue(value);

        // constarrays
        } else if (ctx.constarrays() != null && !ctx.constarrays().isEmpty()) {
            /*String name = ctx.vars().IDENT().getText();
            Value value = new Value(ctx.vars().VALUE().getText());
            variable =  new Variable(name, value, true); */

        // vars
        } else if (ctx.vars() != null && !ctx.vars().isEmpty()) {
            for (LangParser.IdentContext identContext : ctx.vars().ident()) {
                String name = identContext.getText();
                EVariableType type = EVariableType.valueOf(ctx.vars().TYPE().getText().toUpperCase());
                variable = new Variable(name, type,false);
            }
        }

        return variable;
    }

}
