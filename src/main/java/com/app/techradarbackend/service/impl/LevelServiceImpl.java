package com.app.techradarbackend.service.impl;

import com.app.techradarbackend.dao.ElementDAO;
import com.app.techradarbackend.dto.ElementDTO;
import com.app.techradarbackend.dto.ElementLevelUpdateDTO;
import com.app.techradarbackend.entity.ElementEntity;
import com.app.techradarbackend.enums.ElementLevel;
import com.app.techradarbackend.exception.ResourceNotFoundException;
import com.app.techradarbackend.mapper.ElementMapper;
import com.app.techradarbackend.service.ElementService;
import com.app.techradarbackend.service.LevelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class LevelServiceImpl implements LevelService {
    private final ElementDAO elementDAO;
    private final ElementMapper elementMapper;
    private final ElementService elementService;

    @Override
    public ElementDTO updateElementLevel(int elementId, ElementLevelUpdateDTO elementLevelUpdateDTO) {
        ElementEntity element = elementService.getByElementId(elementId);
        ElementLevel level = elementLevelUpdateDTO.getLevel();
        element.setLevel(level);
        elementMapper.mapLevelPatchDTOToEntity(elementLevelUpdateDTO, element);
        return elementMapper.mapEntityToDTO(elementDAO.save(element));
    }

    @Override
    public List<ElementDTO> getAllElementsByLevelId(Integer levelId) {
        ElementLevel level = getElementLevelByLevelId(levelId);
        List<ElementEntity> elementList = elementDAO.getElementEntitiesByLevel(level);
        return elementMapper.mapEntityListToDTOList(elementList);
    }

    private ElementLevel getElementLevelByLevelId(Integer levelId) {
        return Arrays.stream(ElementLevel.values()).filter(level -> level.getLevelId() == levelId).findFirst().orElseThrow(
                () -> new ResourceNotFoundException("Level", "ID", levelId)
        );
    }
}
