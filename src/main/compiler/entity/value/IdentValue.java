package main.compiler.entity.value;

/**
 * ???
 */
public class IdentValue extends Value {

    private String name;
    private int index = -1;
    private String indexName;

    public IdentValue(String name) {
        this.name = name;
    }

    public IdentValue(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public IdentValue(String name, String indexName) {
        this.name = name;
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
}
