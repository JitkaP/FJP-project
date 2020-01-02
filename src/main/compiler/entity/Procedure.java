package main.compiler.entity;

/**
 * This class represents procedure.
 */
public class Procedure extends Symbol {

    /**
     * Instance of Block
     */
    private Block block;

    public Procedure(String name, Block block) {
        super();
        this.block = block;
        setName(name);
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    @Override
    public String toString() {
        return "Procedure{" +
                "name=" + getName() +
                '}';
    }
}
