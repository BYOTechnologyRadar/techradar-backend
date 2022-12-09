package com.app.techradarbackend.mapper;

import com.app.techradarbackend.dto.CategoryDTO;
import com.app.techradarbackend.dto.ElementDTO;
import com.app.techradarbackend.dto.RadarCreateAndUpdateDTO;
import com.app.techradarbackend.dto.RadarDTO;
import com.app.techradarbackend.entity.CategoryEntity;
import com.app.techradarbackend.entity.ElementEntity;
import com.app.techradarbackend.entity.RadarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RadarMapper {
    @Mapping(target = "category", ignore = true)
    ElementDTO mapEntityToDTO(ElementEntity elementEntity);

    @Mapping(target = "elementSet", ignore = true)
    @Mapping(target = "radar", ignore = true)
    CategoryDTO mapEntityToDTO(CategoryEntity categoryEntity);

    RadarEntity mapCreateDTOToEntity(RadarCreateAndUpdateDTO radarCreateAndUpdateDTO);

    RadarDTO mapEntityToDTO(RadarEntity radarEntity);

    List<RadarDTO> mapEntityListToDTOList(List<RadarEntity> radarsList);

    void mapUpdateDTOToEntity(RadarCreateAndUpdateDTO radarCreateAndUpdateDTO, @MappingTarget RadarEntity radar);
}
