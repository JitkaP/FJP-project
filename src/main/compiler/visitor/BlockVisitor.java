package main.compiler.visitor;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.*;

import java.util.ArrayList;
import java.util.List;

public class BlockVisitor extends LangBaseVisitor<Block> {

    @Override
    public Block visitBlock(LangParser.BlockContext ctx) {
        for (LangParser.ProcedureContext procedureContext: ctx.procedure()) {
            Procedure proc = new ProcedureVisitor().visit(procedureContext);
        }

        List<Variable> variables = getVariables(ctx.declaration());
        List<Procedure> procedures = getProcedures(ctx.procedure());
        //List<Block> blocks = getBlocks();
        //Statement statement = getStatement();

        new AssignmentStatementVisitor().visit(ctx.statement());

        return new Block(variables, procedures, null, null);
        //return null;
    }

    private List<Procedure> getProcedures(List<LangParser.ProcedureContext> procedureContextList) {
        List<Procedure> procedures = new ArrayList<>();

        Procedure currentProcedure;
        for (LangParser.ProcedureContext procedureContext: procedureContextList) {
            currentProcedure = new ProcedureVisitor().visitProcedure(procedureContext);
            procedures.add(currentProcedure);
        }

        return procedures;
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
