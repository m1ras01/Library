package kz.miras.spring.models;

public class Author {
    private int authorId;
    private String authorName;
    private int born;
    public Author(){}
    public Author(int authorId,String authorName,int born){
        this.authorId = authorId;
        this.authorName = authorName;
        this.born = born;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getBorn() {
        return born;
    }

    public void setBorn(int born) {
        this.born = born;
    }
}
