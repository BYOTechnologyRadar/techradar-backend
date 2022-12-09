package com.app.techradarbackend.service;

import com.app.techradarbackend.dto.ElementCreateDTO;
import com.app.techradarbackend.dto.ElementDTO;
import com.app.techradarbackend.dto.ElementSearchDTO;
import com.app.techradarbackend.dto.ElementUpdateDTO;
import com.app.techradarbackend.entity.ElementEntity;

import java.util.List;

public interface ElementService {
    ElementDTO addElement(ElementCreateDTO elementCreateDTO);

    ElementDTO updateElement(int elementId, ElementUpdateDTO elementUpdateDTO);

    ElementDTO getElementByElementId(int elementId);

    ElementEntity getByElementId(int elementId);

    List<ElementDTO> searchElementByElementName(ElementSearchDTO elementSearchDTO);

    List<ElementDTO> getAllElements();

    void deleteElementByElementId(int elementId);
}
