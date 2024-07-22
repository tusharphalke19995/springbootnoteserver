package org.pucar.dristi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "NoteApiController", description = "APIs to create, update, getAll and getByCaseId for a case.")
public class NoteApiController {

    private static final Logger logger = LoggerFactory.getLogger(NoteApiController.class);

    private NoteService noteService;

    @Operation(
            summary = "Create new note in the registry",
            description = "Open APi for create a new note in the note registry to a case"
    )
    @PostMapping(value = "/note/v1/create")
    public ResponseEntity<NoteDto> createCaseNote(@RequestBody NoteDto noteDto) {
        NoteDto saveCaseNote = noteService.createCaseNote(noteDto);
        return new ResponseEntity<>(saveCaseNote, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get note details",
            description = "Api for getting the note details by note id"
    )
    @GetMapping("/note/v1/get/{id}")
    public ResponseEntity<NoteDto> getNoteById(@PathVariable("id") UUID noteId) {
        NoteDto noteDto = noteService.getCaseNoteById(noteId);
        return ResponseEntity.ok(noteDto);
    }

    @Operation(
            summary = "Get all the created note for the case",
            description = "Api for getting all note to a case"
    )
    @GetMapping("/note/v1/getAll/{caseId}")
    public ResponseEntity<List<NoteDto>> getAllCaseNotesById(@PathVariable("caseId") String caseId) {
        List<NoteDto> noteDto = noteService.getAllCaseNoteById(caseId);
        return ResponseEntity.ok(noteDto);
    }

    @Operation(
            summary = "Update/edit a note",
            description = "API to update the note. Updates can include constitute element change, new note or deletion of note some part."
    )
    @PutMapping("/note/v1/update/{id}")
    public ResponseEntity<NoteDto> updateCaseNote(@PathVariable("id") UUID noteId,
                                                  @RequestBody NoteDto updateCaseNote) {
        NoteDto noteDto = noteService.updateCaseNote(noteId, updateCaseNote);
        return ResponseEntity.ok(noteDto);
    }

}
