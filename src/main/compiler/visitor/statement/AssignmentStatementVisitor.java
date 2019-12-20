package main.compiler.visitor.statement;

import antlr.gen.LangBaseVisitor;
import antlr.gen.LangParser;
import main.compiler.entity.Variable;
import main.compiler.entity.expression.Expression;
import main.compiler.entity.statement.AssignmentStatement;
import main.compiler.visitor.expression.ExpressionVisitor;

import java.util.ArrayList;
import java.util.List;

public class AssignmentStatementVisitor extends LangBaseVisitor<AssignmentStatement> {

    @Override
    public AssignmentStatement visitAssignstmt(LangParser.AssignstmtContext ctx) {
        List<Variable> variables = new ArrayList<>();
        String exp = ctx.expression().getText();

        List<LangParser.IdentContext> names = ctx.ident();
        for (LangParser.IdentContext identContext: names) {
            String name = identContext.getText();

            // type je null, zde jen prirazujeme, v tabulce symbolu by ovsem tato promenna uz mela byt
            Variable variable = new Variable(name, exp, null, false); // todo asi spis predelat, je divne prirazovat skrze konstruktor

            variables.add(variable);
        }

        for (LangParser.Ident_arrContext ident_arrContext : ctx.ident_arr()) {
            String name = ident_arrContext.ident().getText();
            int index = Integer.parseInt(ident_arrContext.NUMBER().getText());
            //variable = new Variable(name, length, type,false);

            // todo - prirazeni, zde tedy mame nazev promenne a pripadne index a pak expression, ktery chceme priradit
            // todo - je to slozitejsi, nebot muzeme napriklad priradit jedno pole druhemu, co pak?
            // todo PROMYSLET
        }

        return new AssignmentStatement(variables);
    }
}
