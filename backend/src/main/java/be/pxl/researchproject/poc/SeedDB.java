package be.pxl.researchproject.poc;

import be.pxl.researchproject.poc.domain.Note;
import be.pxl.researchproject.poc.repository.NoteRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        List<Note> notes = new ArrayList<>();

        // Add sample notes
        notes.add(new Note("Meeting Notes", "Meeting with stakeholders to discuss project requirements and timeline. Participants: John, Mary, David.", new Date()));
        notes.add(new Note("Project Roadmap", "Outlined the project roadmap including milestones and deliverables. Next steps: finalize wireframes and mockups.", new Date()));
        notes.add(new Note("Brainstorming Ideas", "Brainstormed ideas for the new feature set. Potential features discussed: user authentication, data visualization, and third-party integrations.", new Date()));
        notes.add(new Note("Client Feedback", "Received feedback from the client on the initial prototype. Suggestions for improvement: enhance user interface, optimize performance.", new Date()));
        notes.add(new Note("Testing Results", "Tested new features for bugs and usability. Identified several issues related to data validation and error handling.", new Date()));
        notes.add(new Note("UX Design Meeting", "Met with the UX design team to review wireframes and discuss user experience improvements. Agreed on changes to navigation and layout.", new Date()));
        notes.add(new Note("Code Review", "Conducted a code review session to ensure code quality and adherence to coding standards. Addressed issues related to naming conventions and code duplication.", new Date()));
        notes.add(new Note("Performance Optimization", "Optimized database queries to improve application performance. Implemented caching mechanism for frequently accessed data.", new Date()));
        notes.add(new Note("Release Planning", "Discussed the scope and timeline for the next software release. Planned release date: end of month. Features to include: reporting module and integration with external APIs.", new Date()));
        notes.add(new Note("Security Assessment", "Performed security assessment to identify vulnerabilities in the application. Addressed issues related to input validation and access control.", new Date()));

        // Save all notes to the database
        noteRepository.saveAll(notes);
    }
}
