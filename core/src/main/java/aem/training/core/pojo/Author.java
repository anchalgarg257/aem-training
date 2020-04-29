package aem.training.core.pojo;

public class Author {
    private String author;
    private String designation;
    private String description;
    private String fblink;

    public Author(String author, String designation, String description, String fblink) {
        this.author = author;
        this.designation = designation;
        this.description = description;
        this.fblink = fblink;
    }

    public String getAuthor() {
        return author;
    }

    public String getDesignation() {
        return designation;
    }

    public String getDescription() {
        return description;
    }

    public String getFblink() {
        return fblink;
    }
}
