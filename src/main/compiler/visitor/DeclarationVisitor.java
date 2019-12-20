package main.compiler.visitor;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.Variable;
import main.compiler.enums.EVariableType;

import java.util.ArrayList;
import java.util.List;

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

        // constarrays
        } else if (ctx.constarrays() != null && !ctx.constarrays().isEmpty()) {
            EVariableType type = EVariableType.valueOf(ctx.consts().TYPE().getText().toUpperCase());
            String name = ctx.constarrays().ident().getText();
            List<LangParser.ValueContext> values = ctx.constarrays().value();

            List<Object> newValues = new ArrayList<>();
            for (LangParser.ValueContext valueContext: values) {
                String s = valueContext.getText();
                newValues.add(s);
            }

            variable =  new Variable(name, newValues, type,true);

        // vars
        } else if (ctx.vars() != null && !ctx.vars().isEmpty()) {
            EVariableType type = EVariableType.valueOf(ctx.vars().TYPE().getText().toUpperCase());

            for (LangParser.IdentContext identContext : ctx.vars().ident()) {
                String name = identContext.getText();
                variable = new Variable(name, "", type,false);
            }

            for (LangParser.Ident_arrContext ident_arrContext : ctx.vars().ident_arr()) {
                String name = ident_arrContext.ident().getText();
                int length = Integer.parseInt(ident_arrContext.NUMBER().getText());
                variable = new Variable(name, length, type,false);
            }
        }

        return variable;
    }

}
