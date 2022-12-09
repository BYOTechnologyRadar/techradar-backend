package com.app.techradarbackend.service;

import com.app.techradarbackend.dto.ElementDTO;
import com.app.techradarbackend.dto.ElementVersionUpdateDTO;

import java.util.List;

public interface VersionService {
    ElementDTO updateElementVersion(Integer elementId, ElementVersionUpdateDTO elementVersionUpdateDTO);

    List<ElementDTO> getAllElementsByVersionId(int versionId);
}
