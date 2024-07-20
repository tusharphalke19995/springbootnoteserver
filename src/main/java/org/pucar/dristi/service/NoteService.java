package org.pucar.dristi.service;

import org.pucar.dristi.dto.NoteDto;

import java.util.List;
import java.util.UUID;

public interface NoteService {
    NoteDto createCaseNote(NoteDto noteDto);
    NoteDto getCaseNoteById(UUID id);
    List<NoteDto> getAllCaseNote();
    List<NoteDto> getAllCaseNoteById(String caseId);

    NoteDto updateCaseNote(UUID noteId, NoteDto noteDto);
}
