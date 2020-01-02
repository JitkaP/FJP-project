package main.compiler.visitor.statement;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.statement.BeginStatement;
import main.compiler.entity.statement.Statement;

import java.util.ArrayList;
import java.util.List;

/**
 * Visitor for BeginStatement class.
 */
public class BeginStatementVisitor extends LangBaseVisitor<BeginStatement> {

    /**
     * Method for visit BeginStatement
     * @param ctx context of the BeginStatement
     * @return object of BeginStatement class
     */
    @Override
    public BeginStatement visitBeginstmt(LangParser.BeginstmtContext ctx) {
        List<Statement> statements = new ArrayList<>();

        for (LangParser.StatementContext statementContext : ctx.statement()) {
            Statement statement = new StatementVisitor().visit(statementContext);
            statements.add(statement);
        }

        return new BeginStatement(statements);
    }
}
