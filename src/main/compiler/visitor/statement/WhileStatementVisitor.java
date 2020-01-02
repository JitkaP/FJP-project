package main.compiler.visitor.statement;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.Condition;
import main.compiler.entity.statement.Statement;
import main.compiler.entity.statement.WhileStatement;
import main.compiler.visitor.ConditionVisitor;

/**
 * Visitor for WhileStatement class.
 */
public class WhileStatementVisitor extends LangBaseVisitor<WhileStatement> {

    /**
     * Method for visit WhileStatement
     * @param ctx context of the WhileStatement
     * @return object of WhileStatement class
     */
    @Override
    public WhileStatement visitWhilestmt(LangParser.WhilestmtContext ctx) {
        Condition condition = new ConditionVisitor().visit(ctx.condition());
        Statement statement = new StatementVisitor().visit(ctx.statement());
        return new WhileStatement(condition, statement);
    }
}
