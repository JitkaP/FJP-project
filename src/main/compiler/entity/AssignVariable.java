package main.compiler.entity;

import main.compiler.entity.expression.*;

/**
 * This class represents variable in assignment statement.
 */
public class AssignVariable {

    /**
     * Name of the assign variable
     */
    private String name;

    /**
     * Index in array (if it is array).
     */
    private int index = -1;

    /**
     * Ident name for index in array (if it is array).
     */
    private String indexName = null;

    private Expression expression;

    public AssignVariable(String name, Expression exp) {
        this.name = name;
        this.expression = exp;
    }

    public AssignVariable(String name, Expression exp, int index) {
        this(name, exp);
        this.index = index;
    }

    public AssignVariable(String name, Expression exp, String indexName) {
        this(name, exp);
        this.indexName = indexName;
    }

    public AssignVariable(String name, Expression exp, int index, String indexName) {
        this(name, exp, index);
        this.indexName = indexName;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public String getIndexName() {
        return indexName;
    }

    public Expression getExpression() {
        return expression;
    }
}
