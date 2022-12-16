package com.app.techradarbackend.controller;

import com.app.techradarbackend.configuration.SwaggerConfiguration;
import com.app.techradarbackend.dto.ElementDTO;
import com.app.techradarbackend.dto.ElementVersionUpdateDTO;
import com.app.techradarbackend.service.VersionService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/elements")
@AllArgsConstructor
@Api(tags = {SwaggerConfiguration.VERSION_TAG})
@CrossOrigin(origins = "http://localhost:4200")
public class VersionController {
    private final VersionService versionService;

    @PatchMapping("/{elementId}/version")
    public ElementDTO updateElementVersion(@PathVariable Integer elementId, @Valid @RequestBody ElementVersionUpdateDTO elementVersionUpdateDTO) {
        return versionService.updateElementVersion(elementId, elementVersionUpdateDTO);
    }

    @GetMapping("/version/{versionId}")
    public List<ElementDTO> getAllElementsByVersionId(@PathVariable Integer versionId) {
        return versionService.getAllElementsByVersionId(versionId);
    }
}
