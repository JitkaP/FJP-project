package main.compiler.entity.statement;

import main.compiler.enums.EStatementType;

public abstract class Statement {
    private EStatementType type;

    public EStatementType getType() {
        return type;
    }

    public void setType(EStatementType type) {
        this.type = type;
    }
}
