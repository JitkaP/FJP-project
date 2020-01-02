package main.compiler.visitor.statement;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.statement.CallStatement;

/**
 * Visitor for CallStatement class.
 */
public class CallStatementVisitor extends LangBaseVisitor<CallStatement> {

    /**
     * Method for visit CallStatement
     * @param ctx context of the CallStatement
     * @return object of CallStatement class
     */
    @Override
    public CallStatement visitCallstmt(LangParser.CallstmtContext ctx) {
        String name = ctx.ident().getText();
        return new CallStatement(name);
    }
}
