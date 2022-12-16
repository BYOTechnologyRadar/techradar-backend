package com.app.techradarbackend.controller;

import com.app.techradarbackend.configuration.SwaggerConfiguration;
import com.app.techradarbackend.dto.RadarCreateAndUpdateDTO;
import com.app.techradarbackend.dto.RadarDTO;
import com.app.techradarbackend.dto.RadarSearchDTO;
import com.app.techradarbackend.service.RadarService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/radars")
@AllArgsConstructor
@Api(tags = {SwaggerConfiguration.RADAR_TAG})
@CrossOrigin(origins = "http://localhost:4200")
public class RadarController {
    private final RadarService radarService;

    @PostMapping
    public RadarDTO createRadar(@Valid @RequestBody List<Integer> categoryIdList, RadarCreateAndUpdateDTO radarCreateAndUpdateDTO) {
        return radarService.createRadar(radarCreateAndUpdateDTO, categoryIdList);
    }

    @PutMapping("/{radarId}")
    public RadarDTO updateRadar(@PathVariable Integer radarId, @Valid @RequestBody RadarCreateAndUpdateDTO radarCreateAndUpdateDTO) {
        return radarService.updateRadar(radarId, radarCreateAndUpdateDTO);
    }

    @GetMapping("/{radarId}")
    public RadarDTO getRadarByRadarId(@PathVariable Integer radarId) {
        return radarService.getRadarByRadarId(radarId);
    }

    @GetMapping
    public List<RadarDTO> getAllRadars() {
        return radarService.getAllRadars();
    }

    @PostMapping("/search")
    public List<RadarDTO> searchRadarsByRadarName(@Valid @RequestBody RadarSearchDTO radarSearchDTO) {
        return radarService.searchRadarsByRadarName(radarSearchDTO);
    }

    @DeleteMapping
    public void deleteRadarByRadarId(Integer radarId) {
        radarService.deleteRadarByRadarId(radarId);
    }
}
