package main.compiler.visitor;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.Value;
import main.compiler.entity.Variable;

public class DeclarationVisitor extends LangBaseVisitor<Variable> {

    @Override
    public Variable visitDeclaration(LangParser.DeclarationContext ctx) {

        System.out.println("Typ: " + ctx.consts().TYPE().getText());
        System.out.println("Identifikator: " + ctx.consts().IDENT().getText());
        System.out.println("Hodnota: " + ctx.consts().VALUE().getText());

        return null;
    }
}
