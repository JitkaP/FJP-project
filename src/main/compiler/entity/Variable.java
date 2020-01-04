package main.compiler.entity;

import main.compiler.entity.expression.Expression;
import main.compiler.entity.value.*;
import main.compiler.enums.EVariableType;

import java.util.List;

/**
 * This class represents variable.
 */
public class Variable extends Symbol {

    // assignment - either value or expression is set (other is null)
    /**
     * Value of the Variable
     */
    private Value value = null;

    /**
     * Expression of the Variable
     */
    private Expression expression = null;

    /**
     * Is Variable constant
     */
    private boolean isConst;

    /**
     * Type of the Variable
     */
    private EVariableType type;

    /**
     * Length of the Variable - if Variable represents array
     */
    private int length = 0;

    /**
     * Length of the Variable - if Variable represents array and index of the Variable is represented by identificator
     */
    private String lengthName = null;

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

    public Variable(String name, EVariableType type, boolean isConst, String valueString)
    {
        this(name, type, isConst);
        setValue(valueString);
    }

    public Variable(String name, List<Object> values, EVariableType type, boolean isConst)
    {
        this(name, type, isConst);
        setValue(values);
    }

    /**
     * Returns address of the Variable. If the Variable is array, returns address of the first element in the array.
     * @return address of the Variable
     */
    @Override
    public int getAddress() {
        if (type == EVariableType.BOOL || type == EVariableType.CHAR || type == EVariableType.INT) {
            return super.getAddress();
        } else { // arrays
            return super.getAddress() + 1; // at address[0] is stored array length
        }
    }

    public Value getValue() {
        return value;
    }

    /**
     * Returns value at index. Useful for arrays.
     * @param index index of the wanted value
     * @return value at entered index
     */
    public Value getValue(int index) {
        if (index < 0) return getValue();

        switch (this.type) {
            case ARRAY_CHAR:
                char[] char_array = ((ArrayCharValue) this.value).getArray();
                return new CharValue(char_array[index]);
            case ARRAY_BOOL:
                boolean[] bool_array = ((ArrayBoolValue) this.value).getArray();
                return new BoolValue(bool_array[index]);
            case ARRAY_INT:
                int[] int_array = ((ArrayIntValue) this.value).getArray();
                return new IntValue(int_array[index]);
        }

        return null;
    }

    /**
     * Sets entered value at entered index, Variable has to be array.
     * @param value value to set
     * @param index index in the Variable array
     */
    public void setValue(Value value, int index) {
        switch (this.type) {
            case ARRAY_CHAR:
                ((ArrayCharValue) this.value).getArray()[index] = ((CharValue) value).getChar();
                return;
            case ARRAY_BOOL:
                ((ArrayBoolValue) this.value).getArray()[index] = ((BoolValue) value).getBool();
                return;
            case ARRAY_INT:
                ((ArrayIntValue) this.value).getArray()[index] = ((IntValue) value).getInteger();
                return;

            case CHAR:
            case BOOL:
            case INT:
                this.value = value;
                break;
        }
    }

    /**
     * Sets entered value represented by String class. Variable has not to be array.
     * @param valueString entered value represented by String class
     */
    public void setValue(String valueString) {
        if (valueString == null || valueString.isEmpty()) return;

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

    /**
     * Sets the length of the Variable and initializes whole array to 0. Variable has to be array.
     * @param length length of the Variable
     */
    public void setValueWithLength(int length) {
        switch (this.type) {
            case ARRAY_CHAR:
                char[] char_array = new char[length];
                for (int i = 0; i < char_array.length; i++) {
                    char_array[i] = 0;
                }
                this.value = new ArrayCharValue(char_array);
                break;
            case ARRAY_BOOL:
                boolean[] bool_array = new boolean[length];
                for (int i = 0; i < bool_array.length; i++) {
                    bool_array[i] = false;
                }
                this.value = new ArrayBoolValue(bool_array);
                break;
            case ARRAY_INT:
                int[] int_array = new int[length];
                for (int i = 0; i < int_array.length; i++) {
                    int_array[i] = 0;
                }
                this.value = new ArrayIntValue(int_array);
                break;
        }
    }

    /**
     * Sets values to the Variable. Variable has to be array.
     * @param values list of values to set
     */
    public void setValue(List<Object> values) {
        Object[] array = values.toArray();
        this.length = array.length;
        switch (this.type) {
            case ARRAY_CHAR:
                char[] char_arr = new char[array.length];
                for(int i = 0; i < array.length; i++) char_arr[i] = ((String) array[i]).charAt(0);
                this.value = new ArrayCharValue(char_arr);
                break;
            case ARRAY_BOOL:
                boolean[] boolean_arr = new boolean[array.length];
                for(int i = 0; i < array.length; i++) boolean_arr[i] = Boolean.parseBoolean((String) array[i]);
                this.value = new ArrayBoolValue(boolean_arr);
                break;
            case ARRAY_INT:
                int[] int_arr = new int[array.length];
                for(int i = 0; i < array.length; i++) int_arr[i] = Integer.parseInt((String) array[i]);
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
