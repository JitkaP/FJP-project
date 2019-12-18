package main.compiler.visitor.statement;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.Condition;
import main.compiler.entity.statement.Statement;
import main.compiler.entity.statement.WhileStatement;
import main.compiler.visitor.ConditionVisitor;

public class WhileStatementVisitor extends LangBaseVisitor<WhileStatement> {

    @Override
    public WhileStatement visitWhilestmt(LangParser.WhilestmtContext ctx) {
        Condition condition = new ConditionVisitor().visit(ctx.condition());
        Statement statement = new StatementVisitor().visit(ctx.statement());
        return new WhileStatement(condition, statement);
    }

}
