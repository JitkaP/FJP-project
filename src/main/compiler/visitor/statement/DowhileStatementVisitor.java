package main.compiler.visitor.statement;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.Condition;
import main.compiler.entity.statement.DowhileStatement;
import main.compiler.entity.statement.Statement;
import main.compiler.visitor.ConditionVisitor;

/**
 * Visitor for DowhileStatement class.
 */
public class DowhileStatementVisitor extends LangBaseVisitor<DowhileStatement> {

    /**
     * Method for visit DowhileStatement
     * @param ctx context of the DowhileStatement
     * @return object of DowhileStatement class
     */
    @Override
    public DowhileStatement visitDowhilestmt(LangParser.DowhilestmtContext ctx) {
        Condition condition = new ConditionVisitor().visit(ctx.condition());
        Statement statement = new StatementVisitor().visit(ctx.statement());
        return new DowhileStatement(condition, statement);
    }

}
