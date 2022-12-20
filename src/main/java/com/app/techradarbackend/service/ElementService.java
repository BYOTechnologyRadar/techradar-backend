package com.app.techradarbackend.service;

import com.app.techradarbackend.dto.ElementCategoryUpdateDTO;
import com.app.techradarbackend.dto.ElementCreateDTO;
import com.app.techradarbackend.dto.ElementDTO;
import com.app.techradarbackend.dto.ElementSearchDTO;
import com.app.techradarbackend.dto.ElementUpdateDTO;
import com.app.techradarbackend.entity.ElementEntity;

import java.util.List;

public interface ElementService {
    ElementDTO addElement(ElementCreateDTO elementCreateDTO);

    ElementDTO updateElement(int elementId, ElementUpdateDTO elementUpdateDTO);

    ElementDTO getElementById(int elementId);

    ElementEntity getById(int elementId);

    ElementDTO updateElementCategory(int elementId, ElementCategoryUpdateDTO elementCategoryUpdateDTO);

    List<ElementDTO> searchElementByName(ElementSearchDTO elementSearchDTO);

    List<ElementDTO> getAllElements();

    List<ElementDTO> getAllElementsByCategoryId(int categoryId);

    void deleteElementById(int elementId);
}
