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

    private int length = 0;
    private String lengthName = null;

    @Override
    public int getAddress() {
        if (type == EVariableType.BOOL || type == EVariableType.CHAR || type == EVariableType.INT) {
            return super.getAddress();
        } else { // arrays
            return super.getAddress() + 1; // at address[0] is stored array length
        }
    }

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

    public void setValue(Value value) {
        switch (this.type) {
            case CHAR:
                if (!(value instanceof CharValue)) {
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
            case CHAR:
                this.value = new CharValue(valueString.charAt(0));
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
            case ARRAY_CHAR:
                this.value = new ArrayCharValue(new char[length]);
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
            case ARRAY_CHAR:
                char[] char_arr = new char[array.length];
                for(int i = 0; i < array.length; i++) char_arr[i] = (char) array[i];
                this.value = new ArrayCharValue(char_arr);
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
