package main.compiler.visitor;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.*;
import main.compiler.entity.statement.Statement;
import main.compiler.visitor.statement.StatementVisitor;

import java.util.ArrayList;
import java.util.List;

public class BlockVisitor extends LangBaseVisitor<Block> {

    @Override
    public Block visitBlock(LangParser.BlockContext ctx) {

        List<Variable> variables = getVariables(ctx.declaration());
        List<Procedure> procedures = getProcedures(ctx.procedure());
        Statement statement = getStatement(ctx.statement());

        return new Block(variables, procedures, statement);
    }

    private Statement getStatement(LangParser.StatementContext statementContext) {
        Statement statement = new StatementVisitor().visit(statementContext);

        return statement;
    }

    private List<Procedure> getProcedures(List<LangParser.ProcedureContext> procedureContextList) {
        List<Procedure> procedures = new ArrayList<>();
        Procedure currentProcedure;

        for (LangParser.ProcedureContext procedureContext : procedureContextList) {
            currentProcedure = new ProcedureVisitor().visit(procedureContext);

            if (!containsProcedure(procedures, currentProcedure)) {
                procedures.add(currentProcedure);
            }
            else {
                //vyhodit vyjimku
            }

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

    private boolean containsProcedure(List<Procedure> procedures, Procedure procedure) {
        for (Procedure currentProcedure : procedures) {
            if (currentProcedure.getName().equals(procedure.getName())) {
                return true;
            }
        }
        return false;
    }
}
