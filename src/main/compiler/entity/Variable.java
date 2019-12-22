package main.compiler.entity;

import main.compiler.entity.expression.Expression;
import main.compiler.entity.value.*;
import main.compiler.enums.EVariableType;

import java.util.List;

public class Variable extends Symbol {

    // assignment - either value or expression is set (other is null)
    private Value value = null;
    private Expression expression = null;

    private boolean isConst;
    private EVariableType type;

    private int length;
    private String lengthName;

    private Variable(String name, EVariableType type, boolean isConst)
    {
        super.setName(name);
        this.type = type;
        this.isConst = isConst;
    }

    public Variable(String name, int length, EVariableType type, boolean isConst)
    {
        this(name, type, isConst);
        setValueWithLength(length);
        this.length = length;
    }

    public Variable(String name, String lengthName, EVariableType type, boolean isConst)
    {
        this(name, type, isConst);
        this.lengthName = lengthName;
    }

    public Variable(String name, List<Object> values, EVariableType type, boolean isConst)
    {
        this(name, type, isConst);
        setValue(values);
    }

    public Value getValue() {
        return value;
    }

    public int getIntValue() {
        switch (this.type) {
            case STRING:
                return ((StringValue) this.value).getString().charAt(0); // jen na zkousku se vrati ascii prvniho znaku - todo!!
            case BOOL:
                boolean b = ((BoolValue) this.value).getBool();
                return b ? 1 : 0; // 1=true, 0=false
            case INT:
                return ((IntValue) this.value).getInteger();
        }

        return -1;
    }

    public void setValue(Value value) {
        switch (this.type) {
            case STRING:
                if (!(value instanceof StringValue)) {
                    // vyjimka
                }
                break;
            case BOOL:
                if (!(value instanceof BoolValue)) {
                    // vyjimka
                }
                break;
            case INT:
                if (!(value instanceof IntValue)) {
                    // vyjimka
                }
                break;
        }
        this.value = value;
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

    private void setValueWithLength(int length) {
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

    public EVariableType getType() {
        return type;
    }

    public int getLength() {
        return length;
    }

    public Expression getExpression() {
        return expression;
    }

    public String getLengthName() {
        return lengthName;
    }

}
