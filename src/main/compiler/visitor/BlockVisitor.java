package main.compiler.visitor;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.*;

import java.util.ArrayList;
import java.util.List;

public class BlockVisitor extends LangBaseVisitor<Block> {

    @Override
    public Block visitBlock(LangParser.BlockContext ctx) {

        List<Variable> variables = getVariables(ctx.declaration());
        //List<Procedure> procedures = getProcedures();
        //List<Block> blocks = getBlocks();
        //Statement statement = getStatement();

        //return new Block(variables, procedures, blocks, statement);
        return null;
    }

    private List<Variable> getVariables(List<LangParser.DeclarationContext> declarationContextList) {
        List<Variable> variables = new ArrayList<>();
        Variable currentVariable;

        for (LangParser.DeclarationContext declarationContext : declarationContextList) {
            currentVariable = new DeclarationVisitor().visit(declarationContext);

            if (!containsVariable(variables, currentVariable)) {
                variables.add(currentVariable);
            }
            else {
                // vyhodit vyjimku
            }
        }

        return variables;
    }

    private boolean containsVariable(List<Variable> variables, Variable variable) {
        for (Variable currentVariable : variables) {
            if (currentVariable.getName().equals(variable.getName())) {
                return true;
            }
        }
        return false;
    }
}
