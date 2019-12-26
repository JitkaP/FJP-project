package main.compiler.visitor.statement;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.statement.Statement;
import main.compiler.enums.EStatementType;

public class StatementVisitor extends LangBaseVisitor<Statement> {

    @Override public Statement visitStatement(LangParser.StatementContext ctx) {
        Statement statement = null;

        if (ctx.assignstmt() != null) {
            statement = new AssignmentStatementVisitor().visit(ctx.assignstmt());
            statement.setType(EStatementType.ASSIGN);
        }
        else if (ctx.callstmt() != null) {
            statement = new CallStatementVisitor().visit(ctx.callstmt());
            statement.setType(EStatementType.CALL);
        }
        else if (ctx.beginstmt() != null) {
            statement = new BeginStatementVisitor().visit(ctx.beginstmt());
            statement.setType(EStatementType.BEGIN);
        }
        else if (ctx.ifstmt() != null) {
            statement = new IfStatementVisitor().visit(ctx.ifstmt());
            statement.setType(EStatementType.IF);
        }
        else if (ctx.whilestmt() != null) {
            statement = new WhileStatementVisitor().visit(ctx.whilestmt());
            statement.setType(EStatementType.WHILE);
        }
        else if (ctx.dowhilestmt() != null) {
            statement = new DowhileStatementVisitor().visit(ctx.dowhilestmt());
            statement.setType(EStatementType.DOWHILE);
        }
        else if (ctx.forstmt() != null) {
            statement = new ForStatementVisitor().visit(ctx.forstmt());
            statement.setType(EStatementType.FOR);
        }
        else if (ctx.ternarstmt() != null) {
            statement = new TernarStatementVisitor().visit(ctx.ternarstmt());
            statement.setType(EStatementType.TERNAR);
        }
        else if (ctx.writestmt() != null) {
            statement = new WriteStatementVisitor().visit(ctx.writestmt());
            statement.setType(EStatementType.WRITE);
        }
        else if (ctx.readstmt() != null) {
            statement = new ReadStatementVisitor().visit(ctx.readstmt());
            statement.setType(EStatementType.READ);
        } else if (ctx.parallelstmt() != null) {
            statement = new ParallelStatementVisitor().visit(ctx.parallelstmt());
            statement.setType(EStatementType.PARALLEL);
        }

        return statement;
    }
}
