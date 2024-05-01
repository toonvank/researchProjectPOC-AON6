package be.pxl.researchproject.poc.controller;

import be.pxl.researchproject.poc.domain.Note;
import be.pxl.researchproject.poc.dto.NoteDTO;
import be.pxl.researchproject.poc.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> notes = noteService.getAllNotes();
        return ResponseEntity.ok(notes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody NoteDTO noteDTO) {
        Note note = new Note(noteDTO.getTitle(), noteDTO.getContent(), noteDTO.getDate());
        Note savedNote = noteService.createOrUpdateNote(note);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedNote);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody NoteDTO noteDTO) {
        return noteService.getNoteById(id).map(existingNote -> {
            existingNote.setTitle(noteDTO.getTitle());
            existingNote.setContent(noteDTO.getContent());
            existingNote.setDate(noteDTO.getDate());
            return ResponseEntity.ok(noteService.createOrUpdateNote(existingNote));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteService.deleteNoteById(id);
        return ResponseEntity.noContent().build();
    }
}
