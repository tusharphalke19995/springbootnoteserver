package org.pucar.dristi.controller;

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
@RequestMapping("/element")
public class ConstituteElementApiController {

    private ConstituteElementService constituteElementService;

    @GetMapping("/element/v1/getAll/{caseId}")
    public ResponseEntity<List<ConstituteElementDto>> getAllElements(@PathVariable("caseId") String caseId) {
        List<ConstituteElementDto> constituteElementDto = constituteElementService.getAllConstituteElement(caseId);
        return ResponseEntity.ok(constituteElementDto);
    }

    @PostMapping("/element/v1/create")
    public ResponseEntity<ConstituteElementDto> createElement(@RequestBody ConstituteElementDto constituteElementDto) {
        ConstituteElementDto savedConstituteElement = constituteElementService.createElement(constituteElementDto);
        return new ResponseEntity<>(savedConstituteElement, HttpStatus.CREATED);
    }
}
