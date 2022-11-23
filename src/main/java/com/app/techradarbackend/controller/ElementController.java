package com.app.techradarbackend.controller;

import com.app.techradarbackend.entity.CategoryEntity;
import com.app.techradarbackend.entity.ElementEntity;
import com.app.techradarbackend.entity.LevelEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/techradar/api")
public class ElementController {

    @PostMapping("/element")
    public ElementEntity addElement(@RequestBody ElementEntity elementEntity) {
        return null;
    }

    @PutMapping("/element")
    public ElementEntity updateElement(@RequestBody ElementEntity elementEntity) {
        return null;
    }

    @GetMapping("/element/{elementId}")
    public ElementEntity getElementByElementId(@PathVariable int elementId) {
        return null;
    }

    @GetMapping("/elements")
    public List<ElementEntity> getAllElements() {
        return null;
    }

    @GetMapping("/elements/level/{levelId}")
    public List<ElementEntity> getAllElementsByLevelId(@PathVariable int levelId) {
        return null;
    }

    @GetMapping("/elements/category/{categoryId}")
    public List<CategoryEntity> getAllElementsByCategoryId(@PathVariable int categoryId) {
        return null;
    }

    @GetMapping("/elements/radarCategory/{radarCategoryId}")
    public List<CategoryEntity> getAllElementsByRadarCategoryId(@PathVariable int radarCategoryId) {
        return null;
    }

    @PutMapping("/element/{elementId}/level")
    public ElementEntity addLevelToElement(@PathVariable int elementId, @RequestBody LevelEntity levelEntity) {
        return null;
    }

    @PutMapping("/element/{elementId}/category")
    public ElementEntity addCategoryToElement(@PathVariable int elementId, @RequestBody CategoryEntity categoryEntity) {
        return null;
    }

    @DeleteMapping("/element/{elementId}")
    public void deleteElementByElementId(@PathVariable int elementId) {
    }
}
