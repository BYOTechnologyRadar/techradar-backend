package com.app.techradarbackend.service;

import com.app.techradarbackend.dto.ElementDTO;
import com.app.techradarbackend.dto.ElementStatusUpdateDTO;

import java.util.List;

public interface StatusService {
    ElementDTO updateElementStatus(int elementId, ElementStatusUpdateDTO elementStatusUpdateDTO);

    List<ElementDTO> getAllElementsByStatusId(int statusId);

}
