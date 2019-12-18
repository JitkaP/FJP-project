package main.compiler.entity;

import main.compiler.entity.value.BoolValue;
import main.compiler.entity.value.IntValue;
import main.compiler.entity.value.StringValue;
import main.compiler.entity.value.Value;
import main.compiler.enums.EVariableType;

public class Variable extends Symbol {

    private Value value;
    private boolean isConst;
    private EVariableType type;

    public Variable(String name, String valueString, EVariableType type, boolean isConst)
    {
        super.setName(name);
        this.type = type;
        this.isConst = isConst;
        setValue(valueString);
    }

    public Value getValue() {
        return value;
    }

    // type system check
    public void setValue(String valueString) {
        if (this.type == null) return; // todo! nyni pouze aby to slo prelozit, potom by to vlastne nemelo nastat

        switch (this.type) {
            case STRING:
                this.value = new StringValue(valueString);
                break;
            case BOOL:
                boolean b = Boolean.parseBoolean(valueString);
                this.value = new BoolValue(b);
                break;
            case INT:
                int i = Integer.parseInt(valueString);
                this.value = new IntValue(i);
                break;

            //default:
        }
    }

    public boolean isConst() {
        return isConst;
    }

    public void setConst(boolean aConst) {
        isConst = aConst;
    }

    @Override
    public String toString() {
        return "Variable{" +
                "name=" + getName() +
                ", value=" + value +
                ", type=" + type +
                ", isConst=" + isConst +
                '}';
    }
}
