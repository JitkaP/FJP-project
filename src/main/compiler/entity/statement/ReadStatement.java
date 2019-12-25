package main.compiler.entity.statement;

public class ReadStatement extends Statement {

    private String name;
    private int index;
    private String indexName;

    public ReadStatement(String name) {
        this.name = name;
    }

    public ReadStatement(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public ReadStatement(String name, String indexName) {
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
