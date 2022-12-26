package com.app.techradarbackend.mapper;

import com.app.techradarbackend.dto.RadarCreateAndUpdateDTO;
import com.app.techradarbackend.dto.RadarDTO;
import com.app.techradarbackend.dto.RadarInfoDTO;
import com.app.techradarbackend.entity.RadarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RadarMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "categorySet", ignore = true)
    RadarEntity mapCreateDTOToEntity(RadarCreateAndUpdateDTO radarCreateDTO);

    RadarDTO mapEntityToDTO(RadarEntity radarEntity);

    @Mapping(target = "radarDTO.id", source = "id")
    @Mapping(target = "radarDTO.name", source = "name")
    @Mapping(target = "radarDTO.description", source = "description")
    RadarInfoDTO mapEntityToInfoDTO(RadarEntity radarEntity);

    List<RadarDTO> mapEntityListToDTOList(List<RadarEntity> radarsList);

    void mapUpdateDTOToEntity(RadarCreateAndUpdateDTO radarUpdateDTO, @MappingTarget RadarEntity radar);
}
