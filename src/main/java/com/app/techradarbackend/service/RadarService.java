package com.app.techradarbackend.service;

import com.app.techradarbackend.dto.RadarCreateAndUpdateDTO;
import com.app.techradarbackend.dto.RadarDTO;
import com.app.techradarbackend.dto.RadarInfoDTO;
import com.app.techradarbackend.dto.RadarSearchDTO;
import com.app.techradarbackend.entity.RadarEntity;

import java.util.List;

public interface RadarService {
    RadarDTO createRadar(RadarCreateAndUpdateDTO radarCreateDTO);

    RadarDTO updateRadar(int radarId, RadarCreateAndUpdateDTO radarUpdateDTO);

    RadarInfoDTO getRadarById(int radarId);

    RadarEntity getById(int radarId);

    List<RadarDTO> getAllRadars();

    List<RadarDTO> searchRadarsByName(RadarSearchDTO radarSearchDTO);

    void deleteRadarById(int radarId);
}
