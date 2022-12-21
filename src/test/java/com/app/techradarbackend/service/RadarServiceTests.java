package com.app.techradarbackend.service;

import com.app.techradarbackend.dao.RadarDAO;
import com.app.techradarbackend.dataProvider.RadarDataProvider;
import com.app.techradarbackend.dto.RadarCreateAndUpdateDTO;
import com.app.techradarbackend.dto.RadarDTO;
import com.app.techradarbackend.entity.RadarEntity;
import com.app.techradarbackend.exception.ResourceNotFoundException;
import com.app.techradarbackend.mapper.RadarMapper;
import com.app.techradarbackend.mapper.RadarMapperImpl;
import com.app.techradarbackend.service.impl.RadarServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RadarServiceTests {
    @Mock
    private RadarDAO radarDAO;

    @InjectMocks
    private RadarService radarService;

    @Spy
    private RadarMapper radarMapper = new RadarMapperImpl();

    @BeforeClass
    public void initMock() {
        radarService = new RadarServiceImpl();
        MockitoAnnotations.openMocks(this);
    }

    @Test(expectedExceptions = ResourceNotFoundException.class, expectedExceptionsMessageRegExp = ".* Radar .*")
    public void RS_01_Get_Radar_Throws_ResourceNotFoundException() throws ResourceNotFoundException {
        when(radarService.getRadarById(1)).thenThrow(ResourceNotFoundException.class);
    }

    @Test(dataProvider = "getRadarCreateAndUpdateDTOAndRadarEntityAndRadarDTO", dataProviderClass = RadarDataProvider.class)
    public void RS_02_Add_Radar_Successful(RadarCreateAndUpdateDTO radarCreateDTO, RadarEntity radarEntity, RadarDTO radarDTO) {
        when(radarMapper.mapCreateDTOToEntity(radarCreateDTO)).thenReturn(radarEntity);
        when(radarDAO.save(radarEntity)).thenReturn(radarEntity);
        when(radarMapper.mapEntityToDTO(radarEntity)).thenReturn(radarDTO);
    }

    @Test(dataProvider = "getRadarCreateAndUpdateDTOAndRadarEntityAndRadarDTO", dataProviderClass = RadarDataProvider.class)
    public void RS_03_Update_Radar_Successful(RadarCreateAndUpdateDTO radarUpdateDTO, RadarEntity radarEntity, RadarDTO radarDTO) {
        when(radarDAO.findById(1)).thenReturn(Optional.of(radarEntity));
        when(radarService.updateRadar(1, radarUpdateDTO)).thenReturn(radarDTO);

        verify(radarMapper, times(1)).mapUpdateDTOToEntity(radarUpdateDTO, radarEntity);
    }

    @Test(dataProvider = "getRadarEntityListAndRadarDTOList", dataProviderClass = RadarDataProvider.class)
    public void RS_04_Get_All_Categories_Successful(List<RadarEntity> radarEntityList, List<RadarDTO> radarDTOList) {
        when(radarDAO.findAll()).thenReturn(radarEntityList);
        when(radarService.getAllRadars()).thenReturn(radarDTOList);

        verify(radarDAO, times(1)).findAll();
    }

    @Test(dataProvider = "getRadarEntityAndRadarDTO", dataProviderClass = RadarDataProvider.class)
    public void RS_05_Get_Radar_Successful(RadarEntity radarEntity, RadarDTO radarDTO) {
        when(radarDAO.findById(1)).thenReturn(Optional.of(radarEntity));
        when(radarService.getRadarById(1)).thenReturn(radarDTO);

        final RadarDTO radar = radarService.getRadarById(1);
        Assert.assertNotNull(radar);
    }

    @Test
    public void RS_06_Delete_Radar_Successful() {
        radarService.deleteRadarById(1);

        verify(radarDAO, times(1)).deleteById(1);
    }
}
