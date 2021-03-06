package main.compiler.entity.statement;

import main.compiler.entity.Condition;
import main.compiler.entity.expression.Factor;
import main.compiler.entity.expression.NumberExpression;
import main.compiler.entity.expression.Term;
import main.compiler.entity.value.IdentValue;
import main.compiler.enums.EConditionOperator;
import main.compiler.enums.EConditionType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This class represents for statement
 */
public class ForStatement extends Statement {

    /**
     * Name of the controlling variable
     */
    private String name;

    /**
     * Number expression - represents initial state of controlling variable
     */
    private NumberExpression from;

    /**
     * Condition in ForStatement
     */
    private Condition condition;

    /**
     * Statement in ForStatement
     */
    private Statement statement;

    public ForStatement(String name, NumberExpression from, NumberExpression to, Statement statement) {
        this.name = name;
        this.from = from;
        this.statement = statement;

        EConditionOperator operator = EConditionOperator.LESS;

        List<Object> tokens = new LinkedList<>();
        IdentValue identValue = new IdentValue(name);

        List<Object> termObjects = new ArrayList<>();
        termObjects.add((new Factor(identValue)));
        tokens.add(new Term(termObjects));

        NumberExpression numberExpression = new NumberExpression(tokens);

        this.condition = new Condition(numberExpression, to, operator, EConditionType.NUMBER);
    }

    public String getName() {
        return name;
    }

    public NumberExpression getFrom() {
        return from;
    }

    public Statement getStatement() {
        return statement;
    }

    public Condition getCondition() {
        return condition;
    }
}
