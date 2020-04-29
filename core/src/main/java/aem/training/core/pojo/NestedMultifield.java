package aem.training.core.pojo;

public class NestedMultifield {
    private String path;
    private String title;
    private String innewtab;

    public NestedMultifield(String path, String title, String innewtab) {
        this.path = path;
        this.title = title;
        this.innewtab = innewtab;
    }

    public String getPath() {
        return path;
    }

    public String getTitle() {
        return title;
    }

    public String getInnewtab() {
        return innewtab;
    }
}