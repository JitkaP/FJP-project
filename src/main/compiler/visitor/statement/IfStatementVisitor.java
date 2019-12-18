package main.compiler.visitor.statement;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.Condition;
import main.compiler.entity.statement.IfStatement;
import main.compiler.entity.statement.Statement;
import main.compiler.visitor.ConditionVisitor;

public class IfStatementVisitor extends LangBaseVisitor<IfStatement> {

    @Override
    public IfStatement visitIfstmt(LangParser.IfstmtContext ctx) {
        Condition condition = new ConditionVisitor().visit(ctx.condition());
        Statement ifStatement = new StatementVisitor().visit(ctx.statement(0));

        Statement elseStatement = null;
        if (ctx.statement().size() > 1) {
            elseStatement = new StatementVisitor().visit(ctx.statement(1));
        }

        return new IfStatement(condition, ifStatement, elseStatement);
    }

}
