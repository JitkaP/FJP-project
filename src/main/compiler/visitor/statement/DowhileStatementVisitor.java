package main.compiler.visitor.statement;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.Condition;
import main.compiler.entity.statement.DowhileStatement;
import main.compiler.entity.statement.Statement;
import main.compiler.visitor.ConditionVisitor;

public class DowhileStatementVisitor extends LangBaseVisitor<DowhileStatement> {

    @Override
    public DowhileStatement visitDowhilestmt(LangParser.DowhilestmtContext ctx) {
        Condition condition = new ConditionVisitor().visit(ctx.condition());
        Statement statement = new StatementVisitor().visit(ctx.statement());
        return new DowhileStatement(condition, statement);
    }

}
