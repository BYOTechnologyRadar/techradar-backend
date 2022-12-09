package com.app.techradarbackend.service.impl;

import com.app.techradarbackend.dao.ElementDAO;
import com.app.techradarbackend.dto.ElementDTO;
import com.app.techradarbackend.dto.ElementVersionUpdateDTO;
import com.app.techradarbackend.entity.ElementEntity;
import com.app.techradarbackend.enums.ElementVersion;
import com.app.techradarbackend.exception.ResourceNotFoundException;
import com.app.techradarbackend.mapper.ElementMapper;
import com.app.techradarbackend.service.ElementService;
import com.app.techradarbackend.service.VersionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class VersionServiceImpl implements VersionService {
    private final ElementService elementService;
    private final ElementMapper elementMapper;
    private final ElementDAO elementDAO;

    @Override
    public ElementDTO updateElementVersion(Integer elementId, ElementVersionUpdateDTO elementVersionUpdateDTO) {
        ElementEntity element = elementService.getByElementId(elementId);
        ElementVersion version = elementVersionUpdateDTO.getVersion();
        element.setVersion(version);
        elementMapper.mapVersionPatchDTOToEntity(elementVersionUpdateDTO, element);
        return elementMapper.mapEntityToDTO(elementDAO.save(element));
    }

    @Override
    public List<ElementDTO> getAllElementsByVersionId(int versionId) {
        ElementVersion version = getElementVersionByVersionId(versionId);
        List<ElementEntity> elementList = elementDAO.getElementEntitiesByVersion(version);
        return elementMapper.mapEntityListToDTOList(elementList);
    }

    private ElementVersion getElementVersionByVersionId(Integer versionId) {
        return Arrays.stream(ElementVersion.values()).filter(version -> version.getVersionId().equals(versionId)).findFirst().orElseThrow(
                () -> new ResourceNotFoundException("Version", "ID", versionId)
        );
    }
}
