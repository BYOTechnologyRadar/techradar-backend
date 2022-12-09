package com.app.techradarbackend.mapper;

import com.app.techradarbackend.dto.CategoryCreateAndUpdateDTO;
import com.app.techradarbackend.dto.CategoryDTO;
import com.app.techradarbackend.dto.ElementDTO;
import com.app.techradarbackend.dto.RadarDTO;
import com.app.techradarbackend.entity.CategoryEntity;
import com.app.techradarbackend.entity.ElementEntity;
import com.app.techradarbackend.entity.RadarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "category", ignore = true)
    ElementDTO mapElementEntityToDTO(ElementEntity elementEntity);

    @Mapping(target = "categorySet", ignore = true)
    RadarDTO mapEntityToDTO(RadarEntity radarEntity);

    CategoryEntity mapCreateDTOToEntity(CategoryCreateAndUpdateDTO categoryCreateAndUpdateDTO);

    CategoryDTO mapEntityToDTO(CategoryEntity categoryEntity);

    List<CategoryDTO> mapEntityListToDTOList(List<CategoryEntity> categoryList);

    void mapUpdateDTOToEntity(CategoryCreateAndUpdateDTO categoryCreateAndUpdateDTO, @MappingTarget CategoryEntity categoryEntity);
}