package be.pxl.researchproject.poc;

import be.pxl.researchproject.poc.domain.Note;
import be.pxl.researchproject.poc.repository.NoteRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class SeedDB {

    private final NoteRepository noteRepository;

    @Autowired
    public SeedDB(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @PostConstruct
    public void init() {
        seedNotes();
    }

    private void seedNotes() {
        // Add sample notes
        Note note1 = new Note("Meeting Notes", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", new Date());
        Note note2 = new Note("Project Roadmap", "Sed euismod, nisl nec ultricies lacus.", new Date());
        Note note3 = new Note("Brainstorming Ideas", "Nisl nec ultricies lacus.", new Date());

        // Save notes to the database
        noteRepository.save(note1);
        noteRepository.save(note2);
        noteRepository.save(note3);
    }
}
