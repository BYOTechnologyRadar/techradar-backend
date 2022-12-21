package com.app.techradarbackend.mapper;

import com.app.techradarbackend.dataProvider.RadarDataProvider;
import com.app.techradarbackend.dto.RadarCreateAndUpdateDTO;
import com.app.techradarbackend.dto.RadarDTO;
import com.app.techradarbackend.entity.RadarEntity;
import org.mockito.InjectMocks;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RadarMapperTests {
    @InjectMocks
    private RadarMapper radarMapper = new RadarMapperImpl();

    @Test(dataProvider = "getRadarEntity", dataProviderClass = RadarDataProvider.class)
    public void RM_01_mapEntityToDTO(final RadarEntity radarEntity) {
        RadarDTO radarDTO = radarMapper.mapEntityToDTO(radarEntity);

        assertEquals(radarDTO.getId(), radarEntity.getId());
        assertEquals(radarDTO.getName(), radarEntity.getName());
        assertEquals(radarDTO.getDescription(), radarEntity.getDescription());
    }

    @Test(dataProvider = "getRadarCreateDTO", dataProviderClass = RadarDataProvider.class)
    public void RM_02_mapCreateDTOToEntity(final RadarCreateAndUpdateDTO radarCreateDTO) {
        RadarEntity radarEntity = radarMapper.mapCreateDTOToEntity(radarCreateDTO);

        assertEquals(radarEntity.getName(), radarCreateDTO.getName());
        assertEquals(radarEntity.getDescription(), radarCreateDTO.getDescription());
    }
}
