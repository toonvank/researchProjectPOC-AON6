package be.pxl.researchproject.poc.service;

import be.pxl.researchproject.poc.domain.Note;
import be.pxl.researchproject.poc.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    public Note createOrUpdateNote(Note note) {
        Optional<Note> existingNoteOptional = Optional.empty();
        if (note != null && note.getId() != null) {
            existingNoteOptional = noteRepository.findById(note.getId());
        }
        if (existingNoteOptional.isPresent()) {
            Note existingNote = existingNoteOptional.get();
            existingNote.setTitle(note.getTitle());
            existingNote.setContent(note.getContent());
            return noteRepository.save(existingNote);
        } else {
            return noteRepository.save(note);
        }
    }

    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }
}
