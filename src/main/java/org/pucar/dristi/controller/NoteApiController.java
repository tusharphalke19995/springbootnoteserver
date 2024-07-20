package org.pucar.dristi.controller;

import lombok.AllArgsConstructor;
import org.pucar.dristi.dto.NoteDto;
import org.pucar.dristi.service.NoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@CrossOrigin
@RestController
@RequestMapping("/note")
public class NoteApiController {

    private static final Logger logger = LoggerFactory.getLogger(NoteApiController.class);

    private NoteService noteService;

    @PostMapping(value = "/note/v1/create")
    public ResponseEntity<NoteDto> createCaseNote(@RequestBody NoteDto noteDto) {
        NoteDto saveCaseNote = noteService.createCaseNote(noteDto);
        return new ResponseEntity<>(saveCaseNote, HttpStatus.CREATED);
    }

    @GetMapping("/note/v1/get/{id}")
    public ResponseEntity<NoteDto> getNoteById(@PathVariable("id") UUID noteId) {
        NoteDto noteDto = noteService.getCaseNoteById(noteId);
        return ResponseEntity.ok(noteDto);
    }

    @GetMapping("/note/v1/getAll/{caseId}")
    public ResponseEntity<List<NoteDto>> getAllCaseNotesById(@PathVariable("caseId") String caseId) {
        List<NoteDto> noteDto = noteService.getAllCaseNoteById(caseId);
        return ResponseEntity.ok(noteDto);
    }

    @PutMapping("/note/v1/update/{id}")
    public ResponseEntity<NoteDto> updateCaseNote(@PathVariable("id") UUID noteId,
                                                  @RequestBody NoteDto updateCaseNote) {
        NoteDto noteDto = noteService.updateCaseNote(noteId, updateCaseNote);
        return ResponseEntity.ok(noteDto);
    }

}
