package com.app.techradarbackend.service.impl;

import com.app.techradarbackend.dao.RadarDAO;
import com.app.techradarbackend.dto.RadarCreateAndUpdateDTO;
import com.app.techradarbackend.dto.RadarDTO;
import com.app.techradarbackend.dto.RadarInfoDTO;
import com.app.techradarbackend.dto.RadarSearchDTO;
import com.app.techradarbackend.entity.QRadarEntity;
import com.app.techradarbackend.entity.RadarEntity;
import com.app.techradarbackend.exception.ResourceNotFoundException;
import com.app.techradarbackend.mapper.RadarMapper;
import com.app.techradarbackend.service.RadarService;
import com.querydsl.core.BooleanBuilder;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class RadarServiceImpl implements RadarService {
    private RadarDAO radarDAO;
    private RadarMapper radarMapper;

    @Autowired
    public RadarServiceImpl(RadarDAO radarDAO, RadarMapper radarMapper) {
        this.radarDAO = radarDAO;
        this.radarMapper = radarMapper;
    }

    @Override
    public RadarDTO createRadar(RadarCreateAndUpdateDTO radarCreateDTO) {
        RadarEntity radar = radarMapper.mapCreateDTOToEntity(radarCreateDTO);
        radar = radarDAO.save(radar);
        return radarMapper.mapEntityToDTO(radar);
    }

    @Override
    public RadarDTO updateRadar(int radarId, RadarCreateAndUpdateDTO radarUpdateDTO) {
        RadarEntity radar = getById(radarId);
        radarMapper.mapUpdateDTOToEntity(radarUpdateDTO, radar);
        return radarMapper.mapEntityToDTO(radarDAO.save(radar));
    }

    @Override
    public RadarInfoDTO getRadarById(int radarId) {
        RadarEntity radar = getById(radarId);
        return radarMapper.mapEntityToInfoDTO(radar);
    }

    @Override
    public RadarEntity getById(int radarId) {
        return radarDAO.findById(radarId).orElseThrow(
                () -> new ResourceNotFoundException("Radar", "ID", radarId));
    }

    @Override
    public List<RadarDTO> getAllRadars() {
        List<RadarEntity> radarList = radarDAO.findAll();
        return radarMapper.mapEntityListToDTOList(radarList);
    }

    @Override
    public List<RadarDTO> searchRadarsByName(RadarSearchDTO radarSearchDTO) {
        BooleanBuilder booleanBuilder = booleanBuilderForRadarSearch(radarSearchDTO);
        List<RadarEntity> radarList = (List<RadarEntity>) radarDAO.findAll(booleanBuilder);
        return radarMapper.mapEntityListToDTOList(radarList);
    }

    private BooleanBuilder booleanBuilderForRadarSearch(RadarSearchDTO radarSearchDTO) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QRadarEntity qRadarEntity = QRadarEntity.radarEntity;
        if (radarSearchDTO.getName() != null && !radarSearchDTO.getName().isEmpty()) {
            booleanBuilder.and(qRadarEntity.name.containsIgnoreCase(radarSearchDTO.getName()));
        }
        return booleanBuilder;
    }

    @Override
    public void deleteRadarById(int radarId) {
        if (getById(radarId) != null) {
            radarDAO.deleteById(radarId);
        }
    }
}
