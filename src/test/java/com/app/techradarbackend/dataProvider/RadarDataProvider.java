package com.app.techradarbackend.dataProvider;

import com.app.techradarbackend.dto.RadarCreateAndUpdateDTO;
import com.app.techradarbackend.dto.RadarDTO;
import com.app.techradarbackend.dto.RadarInfoDTO;
import com.app.techradarbackend.entity.RadarEntity;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RadarDataProvider {
    private static RadarEntity createRadarEntity() {
        final RadarEntity radarEntity = new RadarEntity();
        radarEntity.setId(1);
        radarEntity.setName("InFiNIT Technology Radar");
        radarEntity.setDescription("A techradar is a visual representation of the technology landscape within a specific organization or field. It typically includes a range of technologies, tools, and platforms, along with their current adoption level and future potential.");
        radarEntity.setCategorySet(new HashSet<>());

        return radarEntity;
    }

    private static RadarDTO createRadarDTO() {
        final RadarDTO radarDTO = new RadarDTO();
        radarDTO.setId(1);
        radarDTO.setName("InFiNIT Technology Radar");
        radarDTO.setDescription("A techradar is a visual representation of the technology landscape within a specific organization or field. It typically includes a range of technologies, tools, and platforms, along with their current adoption level and future potential.");

        return radarDTO;
    }

    private static RadarInfoDTO createRadarInfoDTO() {
        final RadarInfoDTO radarInfoDTO = new RadarInfoDTO();
        final RadarDTO radarDTO = new RadarDTO();
        radarInfoDTO.setRadarDTO(radarDTO);
        radarInfoDTO.setCategorySet(new HashSet<>());

        return radarInfoDTO;
    }


    private static RadarCreateAndUpdateDTO createRadarCreateAndUpdateDTO() {
        final RadarCreateAndUpdateDTO radarCreateAndUpdateDTO = new RadarCreateAndUpdateDTO();
        radarCreateAndUpdateDTO.setName("InFiNIT Technology Radar");
        radarCreateAndUpdateDTO.setDescription("A techradar is a visual representation of the technology landscape within a specific organization or field. It typically includes a range of technologies, tools, and platforms, along with their current adoption level and future potential.");

        return radarCreateAndUpdateDTO;
    }

    @DataProvider
    public Object[][] getRadarCreateAndUpdateDTOAndRadarEntityAndRadarDTO() {
        final RadarCreateAndUpdateDTO radarCreateAndUpdateDTO = createRadarCreateAndUpdateDTO();
        final RadarEntity radarEntity = createRadarEntity();
        final RadarDTO radarDTO = createRadarDTO();

        return new Object[][]{{radarCreateAndUpdateDTO, radarEntity, radarDTO}};
    }

    @DataProvider
    public Object[][] getRadarEntityListAndRadarDTOList() {
        final List<RadarEntity> radarEntityList = createRadarEntityList();
        final List<RadarDTO> radarDTOList = createRadarDTOList();

        return new Object[][]{{radarEntityList, radarDTOList}};
    }

    @DataProvider
    public Object[][] getRadarEntityAndRadarDTO() {
        final RadarEntity radarEntity = createRadarEntity();
        final RadarDTO radarDTO = createRadarDTO();

        return new Object[][]{{radarEntity, radarDTO}};
    }

    @DataProvider
    public Object[][] getRadarEntityAndRadarInfoDTO() {
        final RadarEntity radarEntity = createRadarEntity();
        final RadarInfoDTO radarInfoDTO = createRadarInfoDTO();

        return new Object[][]{{radarEntity, radarInfoDTO}};
    }

    @DataProvider
    public Object[][] getRadarEntity() {
        final RadarEntity radarEntity = createRadarEntity();

        return new Object[][]{{radarEntity}};
    }

    @DataProvider
    public Object[][] getRadarCreateDTO() {
        final RadarCreateAndUpdateDTO radarCreateDTO = createRadarCreateAndUpdateDTO();

        return new Object[][]{{radarCreateDTO}};
    }

    private List<RadarEntity> createRadarEntityList() {
        final List<RadarEntity> radarEntityList = new ArrayList<>();
        final RadarEntity radarEntity1 = new RadarEntity();
        radarEntity1.setId(1);
        radarEntity1.setName("InFiNIT Technology Radar");
        radarEntity1.setDescription("A techradar is a visual representation of the technology landscape within a specific organization or field. It typically includes a range of technologies, tools, and platforms, along with their current adoption level and future potential.");
        radarEntity1.setCategorySet(new HashSet<>());
        radarEntityList.add(radarEntity1);

        final RadarEntity radarEntity2 = new RadarEntity();
        radarEntity2.setId(1);
        radarEntity2.setName("Corp-IT Technology Radar");
        radarEntity2.setDescription("A techradar is a visual representation of the technology landscape within a specific organization or field. It typically includes a range of technologies, tools, and platforms, along with their current adoption level and future potential.");
        radarEntity2.setCategorySet(new HashSet<>());
        radarEntityList.add(radarEntity2);

        return radarEntityList;
    }

    private List<RadarDTO> createRadarDTOList() {
        final List<RadarDTO> radarDTOList = new ArrayList<>();
        final RadarDTO radarDTO1 = new RadarDTO();
        radarDTO1.setId(1);
        radarDTO1.setName("InFiNIT Technology Radar");
        radarDTO1.setDescription("A techradar is a visual representation of the technology landscape within a specific organization or field. It typically includes a range of technologies, tools, and platforms, along with their current adoption level and future potential.");
        radarDTOList.add(radarDTO1);

        final RadarDTO radarDTO2 = new RadarDTO();
        radarDTO2.setId(1);
        radarDTO2.setName("Corp-IT Technology Radar");
        radarDTO2.setDescription("A techradar is a visual representation of the technology landscape within a specific organization or field. It typically includes a range of technologies, tools, and platforms, along with their current adoption level and future potential.");
        radarDTOList.add(radarDTO2);

        return radarDTOList;
    }
}
