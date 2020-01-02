package main.compiler.visitor;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.Variable;
import main.compiler.enums.EVariableType;

import java.util.ArrayList;
import java.util.List;

public class DeclarationVisitor extends LangBaseVisitor<List<Variable>> {

    @Override
    public List<Variable> visitDeclaration(LangParser.DeclarationContext ctx) {
        List<Variable> variables = new ArrayList<>();

        // consts
        if (ctx.consts() != null && !ctx.consts().isEmpty()) {
            String name = ctx.consts().ident().getText();
            EVariableType type = EVariableType.valueOf(ctx.consts().TYPE().getText().toUpperCase());
            String valueString = ctx.consts().value().getText();

            Variable variable = new Variable(name, type,true, valueString);
            variables.add(variable);

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

            Variable variable =  new Variable(name, newValues, type,true);
            variables.add(variable);

        // vars
        } else if (ctx.vars() != null && !ctx.vars().isEmpty()) {
            EVariableType type = EVariableType.valueOf(ctx.vars().TYPE().getText().toUpperCase());

            for (LangParser.IdentContext identContext : ctx.vars().ident()) {
                String name = identContext.getText();
                Variable variable = new Variable(name, "", type,false);
                variables.add(variable);
            }

            for (LangParser.Ident_arrContext ident_arrContext : ctx.vars().ident_arr()) {
                type = EVariableType.valueOf(("array_" + ctx.vars().TYPE().getText()).toUpperCase());

                String name = ident_arrContext.ident(0).getText();

                Variable variable;
                if (ident_arrContext.NUMBER() != null) {
                    int length = Integer.parseInt(ident_arrContext.NUMBER().getText());
                    variable = new Variable(name, length, type,false);
                } else {
                    String lengthName = ident_arrContext.ident(1).getText();
                    variable = new Variable(name, lengthName, type,false);
                }

                variables.add(variable);
            }
        }

        return variables;
    }

}
