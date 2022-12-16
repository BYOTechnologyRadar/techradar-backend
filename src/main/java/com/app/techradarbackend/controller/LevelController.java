package com.app.techradarbackend.controller;

import com.app.techradarbackend.configuration.SwaggerConfiguration;
import com.app.techradarbackend.dto.ElementDTO;
import com.app.techradarbackend.dto.ElementLevelUpdateDTO;
import com.app.techradarbackend.service.LevelService;
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
@Api(tags = {SwaggerConfiguration.LEVEL_TAG})
@CrossOrigin(origins = "http://localhost:4200")
public class LevelController {
    private final LevelService levelService;

    @PatchMapping("/{elementId}/level")
    public ElementDTO updateElementLevel(@PathVariable Integer elementId, @Valid @RequestBody ElementLevelUpdateDTO elementLevelUpdateDTO) {
        return levelService.updateElementLevel(elementId, elementLevelUpdateDTO);
    }

    @GetMapping("/level/{levelId}")
    public List<ElementDTO> getAllElementsByLevelId(@PathVariable Integer levelId) {
        return levelService.getAllElementsByLevelId(levelId);
    }
}
