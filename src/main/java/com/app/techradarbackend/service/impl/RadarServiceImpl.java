package com.app.techradarbackend.service.impl;

import com.app.techradarbackend.dao.CategoryDAO;
import com.app.techradarbackend.dao.RadarDAO;
import com.app.techradarbackend.dto.RadarCreateAndUpdateDTO;
import com.app.techradarbackend.dto.RadarDTO;
import com.app.techradarbackend.dto.RadarSearchDTO;
import com.app.techradarbackend.entity.CategoryEntity;
import com.app.techradarbackend.entity.QRadarEntity;
import com.app.techradarbackend.entity.RadarEntity;
import com.app.techradarbackend.exception.ResourceNotFoundException;
import com.app.techradarbackend.mapper.RadarMapper;
import com.app.techradarbackend.service.CategoryService;
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
    private CategoryDAO categoryDAO;
    private RadarMapper radarMapper;
    private CategoryService categoryService;

    @Autowired
    public RadarServiceImpl(RadarDAO radarDAO, CategoryDAO categoryDAO, RadarMapper radarMapper, CategoryService categoryService) {
        this.radarDAO = radarDAO;
        this.categoryDAO = categoryDAO;
        this.radarMapper = radarMapper;
        this.categoryService = categoryService;
    }

    @Override
    public RadarDTO createRadar(RadarCreateAndUpdateDTO radarCreateAndUpdateDTO, List<Integer> categoryIdList) {
        RadarEntity radar = radarMapper.mapCreateDTOToEntity(radarCreateAndUpdateDTO);
        radar = radarDAO.save(radar);
        for (Integer categoryId : categoryIdList) {
            CategoryEntity category = categoryService.getByCategoryId(categoryId);
            category.setRadar(radar);
            categoryDAO.save(category);
        }
        return radarMapper.mapEntityToDTO(radar);
    }

    @Override
    public RadarDTO updateRadar(int radarId, RadarCreateAndUpdateDTO radarCreateAndUpdateDTO) {
        RadarEntity radar = getByRadarId(radarId);
        radarMapper.mapUpdateDTOToEntity(radarCreateAndUpdateDTO, radar);
        return radarMapper.mapEntityToDTO(radarDAO.save(radar));
    }

    @Override
    public RadarDTO getRadarByRadarId(int radarId) {
        RadarEntity radar = getByRadarId(radarId);
        return radarMapper.mapEntityToDTO(radar);
    }

    @Override
    public RadarEntity getByRadarId(int radarId) {
        return radarDAO.findById(radarId).orElseThrow(
                () -> new ResourceNotFoundException("Radar", "ID", radarId));
    }

    @Override
    public List<RadarDTO> getAllRadars() {
        List<RadarEntity> radarList = radarDAO.findAll();
        return radarMapper.mapEntityListToDTOList(radarList);
    }

    @Override
    public List<RadarDTO> searchRadarsByRadarName(RadarSearchDTO radarSearchDTO) {
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
    public void deleteRadarByRadarId(int radarId) {
        if (getByRadarId(radarId) != null) {
            radarDAO.deleteById(radarId);
        }
    }
}
