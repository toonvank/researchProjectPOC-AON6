package be.pxl.researchproject.poc.dto;

import java.util.Date;

public class NoteDTO {
    private String title;
    private String content;
    private Date date;

    // Constructors, getters, and setters

    // Constructor
    public NoteDTO() {
    }

    public NoteDTO(String title, String content, Date date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    // Getters and setters
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
}
