package org.pucar.dristi.repository;

import org.pucar.dristi.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface NoteRepository extends JpaRepository<Note, UUID> {
    @Query(value = "select n from Note n where n.caseId = :caseId")
    public List<Note> getAllCaseNoteById(@Param("caseId") String caseId);
}
