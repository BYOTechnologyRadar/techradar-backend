package com.app.techradarbackend.service.impl;

import com.app.techradarbackend.dao.ElementDAO;
import com.app.techradarbackend.dto.ElementDTO;
import com.app.techradarbackend.dto.ElementStatusUpdateDTO;
import com.app.techradarbackend.entity.ElementEntity;
import com.app.techradarbackend.enums.ElementStatus;
import com.app.techradarbackend.exception.ResourceNotFoundException;
import com.app.techradarbackend.mapper.ElementMapper;
import com.app.techradarbackend.service.ElementService;
import com.app.techradarbackend.service.StatusService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class StatusServiceImpl implements StatusService {
    private final ElementDAO elementDAO;
    private final ElementService elementService;
    private final ElementMapper elementMapper;

    @Override
    public ElementDTO updateElementStatus(int elementId, ElementStatusUpdateDTO elementStatusUpdateDTO) {
        ElementEntity element = elementService.getByElementId(elementId);
        ElementStatus status = elementStatusUpdateDTO.getStatus();
        element.setStatus(status);
        elementMapper.mapStatusPatchDTOToEntity(elementStatusUpdateDTO, element);
        return elementMapper.mapEntityToDTO(elementDAO.save(element));
    }

    @Override
    public List<ElementDTO> getAllElementsByStatusId(int statusId) {
        ElementStatus status = getElementStatusByStatusId(statusId);
        List<ElementEntity> elementDTOList = elementDAO.getElementEntitiesByStatus(status);
        return elementMapper.mapEntityListToDTOList(elementDTOList);
    }

    private ElementStatus getElementStatusByStatusId(Integer statusId) {
        return Arrays.stream(ElementStatus.values()).filter(level -> level.getStatusId().equals(statusId)).findFirst().orElseThrow(
                () -> new ResourceNotFoundException("Status", "ID", statusId)
        );
    }
}
