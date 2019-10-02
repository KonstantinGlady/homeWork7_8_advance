package lesson1.part1;

import java.util.Objects;

public class Document {

    private static final String DEFAULT_TITLE = "Unknown";

    private String title;
    private String content;

    public Document(String content) {
        this(DEFAULT_TITLE, content);
    }

    public Document(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Document{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(title, document.title) &&
                Objects.equals(content, document.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content);
    }




    public static void main(String[] args) {
        Document doc = new Document("my title", "my content");
        System.out.println(doc);
    }
}
