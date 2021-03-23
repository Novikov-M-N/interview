package domain;

import javax.persistence.*;

@Entity
@Table(name = "hardware")
public class Hardware {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "thread")
    private String thread;

    @Column(name = "length")
    private Integer length;

    @Column(name = "note")
    private String note;

    public Hardware() {}

    public Hardware(String title, String thread, Integer length, String note) {
        this.title = title;
        this.thread = thread;
        this.length = length;
        this.note = note;
    }

    public void setId(Integer id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setThread(String thread) { this.thread = thread; }
    public void setLength(Integer length) { this.length = length; }
    public void setNote(String note) { this.note = note; }

    public Integer getId() { return id; }
    public String getTitle() { return title; }
    public String getThread() { return thread; }
    public Integer getLength() { return length; }
    public String getNote() { return note; }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hardware(")
                .append("id=").append(id)
                .append("title=").append(title).append(", ")
                .append("thread=").append(thread).append(", ")
                .append("length=").append(length).append(", ")
                .append("note=").append(note).append(")");
        return sb.toString();
    }
}
