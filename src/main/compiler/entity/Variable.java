package main.compiler.entity;

public class Variable {

    private String name;
    private Value value;
    private boolean isConst;

    public Variable(String name, Value value, boolean isConst)
    {
        this.name = name;
        this.value = value;
        this.isConst = isConst;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public boolean isConst() {
        return isConst;
    }

    public void setConst(boolean aConst) {
        isConst = aConst;
    }
}
