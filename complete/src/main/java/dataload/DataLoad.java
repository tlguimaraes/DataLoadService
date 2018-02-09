package dataload;

public class DataLoad {

    private final long id;
    private final String content;

    public DataLoad() {
        this.id = -1;
        this.content = "";
    }

    public DataLoad(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
