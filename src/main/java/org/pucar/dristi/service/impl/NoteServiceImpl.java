package org.pucar.dristi.service.impl;

import lombok.AllArgsConstructor;
import org.pucar.dristi.dto.NoteDto;
import org.pucar.dristi.entity.Note;
import org.pucar.dristi.exception.ResourceNotFoundException;
import org.pucar.dristi.mapper.NoteMapper;
import org.pucar.dristi.repository.NoteRepository;
import org.pucar.dristi.service.NoteService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService {

    private NoteRepository noteRepository;

    @Override
    public NoteDto createCaseNote(NoteDto noteDto) {
        Note note = NoteMapper.mapToNote(noteDto);
        note.setCreatedDate(LocalDate.now());
        note.setModifiedDate(LocalDate.now());
        Note savedNote = noteRepository.save(note);
        return NoteMapper.mapToNoteDto(savedNote);
    }

    @Override
    public NoteDto getCaseNoteById(UUID noteId) {
        Note note = noteRepository.findById(noteId).orElseThrow(()-> new ResourceNotFoundException("Case note is not exist with given id: " + noteId));
        return NoteMapper.mapToNoteDto(note);
    }

    @Override
    public List<NoteDto> getAllCaseNoteById(String caseId) {
        List<Note> notes = noteRepository.getAllCaseNoteById(caseId);
        return notes.stream().map(NoteMapper::mapToNoteDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<NoteDto> getAllCaseNote() {
        List<Note> notes = noteRepository.findAll();
        return notes.stream().map(NoteMapper::mapToNoteDto)
                .collect(Collectors.toList());
    }

    @Override
    public NoteDto updateCaseNote(UUID noteId, NoteDto noteDto) {
        Note note = noteRepository.findById(noteId).orElseThrow(
                ()-> new ResourceNotFoundException("Case note is not exist with given id: " + noteId));

        note.setNote(noteDto.getNote());
        note.setCaseId(noteDto.getCaseId());
        note.setModifiedDate(LocalDate.now());
        note.setSubmittedById(noteDto.getSubmittedById());
        note.setConstituteElements(noteDto.getConstituteElements());

        Note updatedNote = noteRepository.save(note);
        return NoteMapper.mapToNoteDto(updatedNote);
    }
}
