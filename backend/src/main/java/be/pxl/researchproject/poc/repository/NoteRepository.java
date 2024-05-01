package be.pxl.researchproject.poc.repository;

import be.pxl.researchproject.poc.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {

}