package main.compiler.visitor.statement;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.expression.StringExpression;
import main.compiler.entity.statement.WriteStatement;
import main.compiler.visitor.expression.StringExpressionVisitor;

public class WriteStatementVisitor extends LangBaseVisitor<WriteStatement> {

    @Override
    public WriteStatement visitWritestmt(LangParser.WritestmtContext ctx) {
        StringExpression stringExpression = new StringExpressionVisitor().visit(ctx.string_expression());
        return new WriteStatement(stringExpression);
    }

}
