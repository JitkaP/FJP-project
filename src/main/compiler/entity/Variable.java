package main.compiler.entity;

import main.compiler.entity.value.*;
import main.compiler.enums.EVariableType;

import java.util.List;

public class Variable extends Symbol {

    private Value value;
    private boolean isConst;
    private EVariableType type;

    private Variable(String name, EVariableType type, boolean isConst)
    {
        super.setName(name);
        this.type = type;
        this.isConst = isConst;
    }

    public Variable(String name, int length, EVariableType type, boolean isConst)
    {
        this(name, type, isConst);
        setValue(length);
    }

    public Variable(String name, String valueString, EVariableType type, boolean isConst)
    {
        this(name, type, isConst);
        setValue(valueString);
    }

    public Variable(String name, List<Object> values, EVariableType type, boolean isConst)
    {
        this(name, type, isConst);
        setValue(values);
    }

    public Value getValue() {
        return value;
    }

    // type system check
    public void setValue(String valueString) {
        if (this.type == null) return; // todo! nyni pouze aby to slo prelozit, potom by to vlastne nemelo nastat
        if (valueString == null || valueString.isEmpty()) return; // mozna pak odebrat?

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
        }
    }

    public void setValue(int length) {
        if (this.type == null) return; // todo! nyni pouze aby to slo prelozit, potom by to vlastne nemelo nastat

        switch (this.type) {
            case ARRAY_STRING:
                this.value = new ArrayStringValue(new String[length]);
                break;
            case ARRAY_BOOL:
                this.value = new ArrayBoolValue(new boolean[length]);
                break;
            case ARRAY_INT:
                this.value = new ArrayIntValue(new int[length]);
                break;
        }
    }

    public void setValue(List<Object> values) {
        if (this.type == null) return; // todo! nyni pouze aby to slo prelozit, potom by to vlastne nemelo nastat

        Object[] array = values.toArray();
        switch (this.type) {
            case ARRAY_STRING:
                this.value = new ArrayStringValue((String[]) values.toArray());
                break;
            case ARRAY_BOOL:
                boolean[] boolean_arr = new boolean[array.length];
                for(int i = 0; i < array.length; i++) boolean_arr[i] = (boolean) array[i];
                this.value = new ArrayBoolValue(boolean_arr);
                break;
            case ARRAY_INT:
                int[] int_arr = new int[array.length];
                for(int i = 0; i < array.length; i++) int_arr[i] = (int) array[i];
                this.value = new ArrayIntValue(int_arr);
                break;
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
