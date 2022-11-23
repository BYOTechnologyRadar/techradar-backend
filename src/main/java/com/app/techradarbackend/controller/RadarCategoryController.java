package com.app.techradarbackend.controller;

import com.app.techradarbackend.entity.CategoryEntity;
import com.app.techradarbackend.entity.RadarCategoryEntity;
import com.app.techradarbackend.entity.RadarEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/techradar/api")
public class RadarCategoryController {
    @PutMapping("/radarCategory/{radarCategoryId}/radar")
    public RadarCategoryEntity addRadarToRadarCategory(@PathVariable int radarCategoryId, @RequestBody RadarEntity radarEntity) {
        return null;
    }

    @PutMapping("/radarCategory/{radarCategoryId}/category")
    public RadarCategoryEntity addCategoryToRadarCategory(@PathVariable int radarCategoryId, @RequestBody CategoryEntity categoryEntity) {
        return null;
    }

    @GetMapping("/radarCategory/{radarCategoryId}")
    public RadarCategoryEntity getRadarCategoryByRadarCategoryId(@PathVariable int radarCategoryId) {
        return null;
    }
}
