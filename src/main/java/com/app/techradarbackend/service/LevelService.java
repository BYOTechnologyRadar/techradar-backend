package com.app.techradarbackend.service;

import com.app.techradarbackend.dto.ElementDTO;
import com.app.techradarbackend.dto.ElementLevelUpdateDTO;

import java.util.List;

public interface LevelService {
    ElementDTO updateElementLevel(int elementId, ElementLevelUpdateDTO elementLevelUpdateDTO);

    List<ElementDTO> getAllElementsByLevelId(Integer levelId);
}
