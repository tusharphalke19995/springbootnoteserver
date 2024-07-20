package org.pucar.dristi.service.impl;

import lombok.AllArgsConstructor;
import org.pucar.dristi.dto.ConstituteElementDto;
import org.pucar.dristi.entity.ConstituteElement;
import org.pucar.dristi.mapper.ConstituteElementMapper;
import org.pucar.dristi.repository.ConstituteElementRepository;
import org.pucar.dristi.service.ConstituteElementService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ConstituteElementServiceImpl implements ConstituteElementService {

    private ConstituteElementRepository constituteElementRepository;

    @Override
    public List<ConstituteElementDto> getAllConstituteElement(String caseId) {
        List<ConstituteElement> constituteElementList = constituteElementRepository.getAllConstituteElements(caseId);

        return constituteElementList.stream().map(ConstituteElementMapper::mapToConstituteDto)
                .collect(Collectors.toList());
    }

    @Override
    public ConstituteElementDto createElement(ConstituteElementDto constituteElementDto) {
        ConstituteElement constituteElement = ConstituteElementMapper.mapToConstituteElement(constituteElementDto);
        ConstituteElement saved = constituteElementRepository.save(constituteElement);
        return ConstituteElementMapper.mapToConstituteDto(saved);
    }
}
