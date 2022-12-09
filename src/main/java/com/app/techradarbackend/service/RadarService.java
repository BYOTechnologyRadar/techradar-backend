package com.app.techradarbackend.service;

import com.app.techradarbackend.dto.RadarCreateAndUpdateDTO;
import com.app.techradarbackend.dto.RadarDTO;
import com.app.techradarbackend.dto.RadarSearchDTO;
import com.app.techradarbackend.entity.RadarEntity;

import java.util.List;

public interface RadarService {
    RadarDTO createRadar(RadarCreateAndUpdateDTO radarCreateAndUpdateDTO, List<Integer> categoryIdList);

    RadarDTO updateRadar(int radarId, RadarCreateAndUpdateDTO radarCreateAndUpdateDTO);

    RadarDTO getRadarByRadarId(int radarId);

    RadarEntity getByRadarId(int radarId);

    List<RadarDTO> getAllRadars();

    List<RadarDTO> searchRadarsByRadarName(RadarSearchDTO radarSearchDTO);

    void deleteRadarByRadarId(int radarId);
}
