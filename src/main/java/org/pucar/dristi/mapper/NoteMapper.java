package org.pucar.dristi.mapper;

import org.pucar.dristi.dto.NoteDto;
import org.pucar.dristi.entity.Note;

public class NoteMapper {
    public static NoteDto mapToNoteDto(Note note) {
        NoteDto noteDto = new NoteDto();
        noteDto.setId(note.getId().toString());
        noteDto.setNote(note.getNote());
        noteDto.setCaseId(note.getCaseId());
        noteDto.setCreatedDate(note.getCreatedDate());
        noteDto.setModifiedDate(note.getModifiedDate());
        noteDto.setSubmittedById(note.getSubmittedById());

        noteDto.setConstituteElements(note.getConstituteElements());

        return noteDto;
    }

    public static Note mapToNote(NoteDto noteDto) {
        Note note = new Note();
        note.setNote(noteDto.getNote());
        note.setCaseId(noteDto.getCaseId());
        note.setCreatedDate(noteDto.getCreatedDate());
        note.setModifiedDate(noteDto.getModifiedDate());
        note.setSubmittedById(noteDto.getSubmittedById());
        note.setConstituteElements(noteDto.getConstituteElements());

        return note;
    }
}
