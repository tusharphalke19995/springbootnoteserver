package org.pucar.dristi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.pucar.dristi.dto.ConstituteElementDto;
import org.pucar.dristi.entity.ConstituteElement;
import org.pucar.dristi.service.ConstituteElementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@CrossOrigin
@RestController
@Tag(name = "ConstituteElementApiController", description = "APIs related to create and getAll constitute element to a case.")
@RequestMapping("/element")
public class ConstituteElementApiController {

    private ConstituteElementService constituteElementService;

    @Operation(
            summary = " Get all constitute element list to a case.",
            description = "API to get all constitute element list by caseId"
    )
    @GetMapping("/element/v1/getAll/{caseId}")
    public ResponseEntity<List<ConstituteElementDto>> getAllElements(@PathVariable("caseId") String caseId) {
        List<ConstituteElementDto> constituteElementDto = constituteElementService.getAllConstituteElement(caseId);
        return ResponseEntity.ok(constituteElementDto);
    }

    @Operation(
            summary = "Create new constitute element in the registry",
            description = "API to create a constitute element registry to a case"
    )
    @PostMapping("/element/v1/create")
    public ResponseEntity<ConstituteElementDto> createElement(@RequestBody ConstituteElementDto constituteElementDto) {
        ConstituteElementDto savedConstituteElement = constituteElementService.createElement(constituteElementDto);
        return new ResponseEntity<>(savedConstituteElement, HttpStatus.CREATED);
    }
}
