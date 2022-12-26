package com.app.techradarbackend.mapper;

import com.app.techradarbackend.dto.CategoryCreateAndUpdateDTO;
import com.app.techradarbackend.dto.CategoryDTO;
import com.app.techradarbackend.dto.CategoryRadarUpdateDTO;
import com.app.techradarbackend.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "radar", ignore = true)
    @Mapping(target = "elementSet", ignore = true)
    CategoryEntity mapCreateDTOToEntity(CategoryCreateAndUpdateDTO categoryCreateAndUpdateDTO);

    @Mapping(target = "radarId", source = "radar.id")
    CategoryDTO mapEntityToDTO(CategoryEntity categoryEntity);

    List<CategoryDTO> mapEntityListToDTOList(List<CategoryEntity> categoryList);

    void mapUpdateDTOToEntity(CategoryCreateAndUpdateDTO categoryCreateAndUpdateDTO, @MappingTarget CategoryEntity categoryEntity);

    void mapRadarPatchDTOToEntity(CategoryRadarUpdateDTO categoryRadarUpdateDTO, @MappingTarget CategoryEntity categoryEntity);

}