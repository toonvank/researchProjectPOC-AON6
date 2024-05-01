package be.pxl.researchproject.poc.dto;

import java.util.Date;

public class NoteDTO {
    private String title;
    private String content;

    // Constructors, getters, and setters

    // Constructor
    public NoteDTO() {
    }

    public NoteDTO(String title, String content, Date date) {
        this.title = title;
        this.content = content;
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
}
