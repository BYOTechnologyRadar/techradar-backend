package com.app.techradarbackend.controller;

import com.app.techradarbackend.entity.RadarEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/techradar/api")
public class RadarController {
    @PostMapping("/radar")
    public RadarEntity addRadarEntity(@RequestBody RadarEntity radarEntity) {
        return null;
    }

    @PutMapping("/radar")
    public RadarEntity updateEntity(@RequestBody RadarEntity radarEntity) {
        return null;
    }

    @GetMapping("/radar/{radarId}")
    public RadarEntity getRadarByRadarId(@PathVariable int radarId) {
        return null;
    }

    @GetMapping("/radars")
    public List<RadarEntity> getRadars() {
        return null;
    }

    @DeleteMapping("/radar/{radarId}")
    public void deleteRadarByRadarId(@PathVariable int radarId) {
    }
}
