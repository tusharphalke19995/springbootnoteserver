package org.pucar.dristi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "Constitute element registry model")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConstituteElementDto {
    private String id;
    private String caseId;
    private String value;
}
