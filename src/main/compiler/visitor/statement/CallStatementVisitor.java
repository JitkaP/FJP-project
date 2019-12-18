package main.compiler.visitor.statement;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.statement.CallStatement;

public class CallStatementVisitor extends LangBaseVisitor<CallStatement> {

    @Override
    public CallStatement visitCallstmt(LangParser.CallstmtContext ctx) {
        return new CallStatement(); // prozatim, aby slo prelozit
    }

}
