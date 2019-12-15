package main.compiler.visitor;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.Value;

public class DeclarationVisitor extends LangBaseVisitor<Value> {

    @Override
    public Value visitDeclaration(LangParser.DeclarationContext ctx) {

        System.out.println("Typ: " + ctx.consts().TYPE().getText());
        System.out.println("Identifikator: " + ctx.consts().IDENT().getText());
        System.out.println("Hodnota: " + ctx.consts().VALUE().getText());

        return null;
    }
}
