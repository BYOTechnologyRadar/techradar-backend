package com.app.techradarbackend.controller;

import com.app.techradarbackend.configuration.SwaggerConfiguration;
import com.app.techradarbackend.dto.ElementCategoryUpdateDTO;
import com.app.techradarbackend.dto.ElementCreateDTO;
import com.app.techradarbackend.dto.ElementDTO;
import com.app.techradarbackend.dto.ElementSearchDTO;
import com.app.techradarbackend.dto.ElementUpdateDTO;
import com.app.techradarbackend.service.ElementService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/elements")
@AllArgsConstructor
@Api(tags = {SwaggerConfiguration.ELEMENT_TAG})
@CrossOrigin(origins = "http://localhost:4200")
public class ElementController {
    private final ElementService elementService;

    @PostMapping
    public ElementDTO addElement(@Valid @RequestBody ElementCreateDTO elementCreateDTO) {
        return elementService.addElement(elementCreateDTO);
    }

    @PutMapping("/{elementId}")
    public ElementDTO updateElement(@PathVariable int elementId, @Valid @RequestBody ElementUpdateDTO elementUpdateDTO) {
        return elementService.updateElement(elementId, elementUpdateDTO);
    }

    @GetMapping("/{elementId}")
    public ElementDTO getElementById(@PathVariable int elementId) {
        return elementService.getElementById(elementId);
    }

    @PatchMapping("/element/{elementId}")
    ElementDTO updateElementCategory(@PathVariable Integer elementId, @Valid @RequestBody ElementCategoryUpdateDTO elementCategoryUpdateDTO) {
        return elementService.updateElementCategory(elementId, elementCategoryUpdateDTO);
    }

    @PostMapping("/search")
    public List<ElementDTO> searchElementByName(@Valid @RequestBody ElementSearchDTO elementSearchDTO) {
        return elementService.searchElementByName(elementSearchDTO);
    }

    @GetMapping
    public List<ElementDTO> getAllElements() {
        return elementService.getAllElements();
    }

    @GetMapping("/category/{categoryId}")
    List<ElementDTO> getAllElementsByCategoryId(@PathVariable Integer categoryId) {
        return elementService.getAllElementsByCategoryId(categoryId);
    }
    @DeleteMapping("/{elementId}")
    public void deleteElementByElementId(@PathVariable int elementId) {
        elementService.deleteElementById(elementId);
    }
}
