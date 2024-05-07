package be.pxl.researchproject.poc.service;

import be.pxl.researchproject.poc.domain.Note;
import be.pxl.researchproject.poc.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Value("${app.upload.dir}")
    private String uploadDir;

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    public Note createOrUpdateNote(Note note) throws IOException {
        if (note != null && note.getPhoto_url() != null && !note.getPhoto_url().isEmpty()) {
            String fileName = UUID.randomUUID().toString() + ".jpg"; // or any other desired file format
            String filePath = uploadDir + File.separator + fileName;
            saveImage(note.getPhoto_url(), filePath);
            note.setPhoto_url(fileName); // Assuming you have a setter for photoUrl in your Note class
        }
        Optional<Note> existingNoteOptional = Optional.empty();
        if (note != null && note.getId() != null) {
            existingNoteOptional = noteRepository.findById(note.getId());
        }
        if (existingNoteOptional.isPresent()) {
            Note existingNote = existingNoteOptional.get();
            existingNote.setTitle(note.getTitle());
            existingNote.setContent(note.getContent());
            existingNote.setPhoto_url(note.getPhoto_url());
            return noteRepository.save(existingNote);
        } else {
            return noteRepository.save(note);
        }
    }

    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }

    private void saveImage(String base64Image, String filePath) throws IOException {
        // Split the Data URL into metadata and image data
        String[] parts = base64Image.split(",");

        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid Base64 string: missing metadata");
        }

        String imageData = parts[1]; // Extract Base64-encoded image data

        byte[] imageBytes = Base64.getDecoder().decode(imageData);

        // Write image data to file
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(imageBytes);
        }
    }
}
