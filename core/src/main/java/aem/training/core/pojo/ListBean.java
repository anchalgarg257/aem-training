package aem.training.core.pojo;

public class ListBean {
    private String author;
    private String dateofbirth;
    private String description;
    private String fblink;

    public ListBean(String author, String dateofbirth, String description, String fblink) {
        this.author = author;
        this.dateofbirth = dateofbirth;
        this.description = description;
        this.fblink = fblink;
    }

    public String getAuthor() {
        return author;
    }

    public String getDesignation() {
        return dateofbirth;
    }

    public String getDescription() {
        return description;
    }

    public String getFblink() {
        return fblink;
    }
}
