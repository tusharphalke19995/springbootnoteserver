package org.pucar.dristi.mapper;


import org.pucar.dristi.dto.ConstituteElementDto;
import org.pucar.dristi.entity.ConstituteElement;

public class ConstituteElementMapper {
    public static ConstituteElementDto mapToConstituteDto(ConstituteElement constituteElement) {
        return new ConstituteElementDto(
                constituteElement.getId().toString(),
                constituteElement.getCaseId(),
                constituteElement.getValue()
        );
    }

    public static ConstituteElement mapToConstituteElement(ConstituteElementDto constituteElementDto) {
        ConstituteElement constituteElement = new ConstituteElement();
        constituteElement.setCaseId(constituteElementDto.getCaseId());
        constituteElement.setValue(constituteElementDto.getValue());
        return constituteElement;
    }
}
