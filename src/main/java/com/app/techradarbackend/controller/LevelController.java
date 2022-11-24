package com.app.techradarbackend.controller;

import com.app.techradarbackend.entity.LevelEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LevelController {
    @PostMapping("/level")
    public LevelEntity addLevel(@RequestBody LevelEntity levelEntity) {
        return null;
    }

    @PutMapping("/level")
    public LevelEntity updateLevel(@RequestBody LevelEntity levelEntity) {
        return null;
    }

    @GetMapping("/level/{levelId}")
    public LevelEntity getLevelByLevelId(@PathVariable int levelId) {
        return null;
    }

    @GetMapping("/levels")
    public List<LevelEntity> getAllLevels() {
        return null;
    }

    @DeleteMapping("/level/{levelId}")
    public void deleteLevelByLevelId(@PathVariable int levelId) {
    }
}
