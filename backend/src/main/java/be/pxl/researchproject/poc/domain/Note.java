package be.pxl.researchproject.poc.domain;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private Date date;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String photo_url;

    public Note() {
    }

    public Note(String title, String content, Date date, String photo_url) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.photo_url = photo_url;
    }

    public Note(String title, String content, Date date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }
}
