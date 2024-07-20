package org.pucar.dristi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.pucar.dristi.entity.ConstituteElement;

import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteDto {
    private String id;
    private String note;
    private String caseId;
    private LocalDate createdDate;
    private LocalDate modifiedDate;
    private String submittedById;
    private List<String> constituteElements = new ArrayList<>();
}
