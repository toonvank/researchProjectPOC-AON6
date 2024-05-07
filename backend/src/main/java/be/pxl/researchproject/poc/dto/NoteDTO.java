package be.pxl.researchproject.poc.dto;

import java.util.Date;

public class NoteDTO {
    private String title;
    private String content;
    private String photo_url; // New field for the image URL

    // Constructors, getters, and setters

    // Constructor
    public NoteDTO() {
    }

    public NoteDTO(String title, String content, String photo_url) {
        this.title = title;
        this.content = content;
        this.photo_url = photo_url;
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

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }
}
