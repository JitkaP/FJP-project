package main.compiler.entity;

/**
 * This abstract class represents symbol - extended by Variable and Procedure
 */
public abstract class Symbol {

    /**
     * Name  of the Symbol
     */
    private String name;

    /**
     * Address of the Symbol in stack
     */
    private int address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }
}
