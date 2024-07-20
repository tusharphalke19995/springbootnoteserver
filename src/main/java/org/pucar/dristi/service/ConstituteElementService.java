package org.pucar.dristi.service;

import org.pucar.dristi.dto.ConstituteElementDto;

import java.util.List;
import java.util.UUID;

public interface ConstituteElementService {
    List<ConstituteElementDto> getAllConstituteElement(String caseId);
    ConstituteElementDto createElement(ConstituteElementDto constituteElementDto);
}
