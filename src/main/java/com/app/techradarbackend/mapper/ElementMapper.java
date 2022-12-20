package com.app.techradarbackend.mapper;

import com.app.techradarbackend.dto.ElementCategoryUpdateDTO;
import com.app.techradarbackend.dto.ElementCreateDTO;
import com.app.techradarbackend.dto.ElementDTO;
import com.app.techradarbackend.dto.ElementLevelUpdateDTO;
import com.app.techradarbackend.dto.ElementStatusUpdateDTO;
import com.app.techradarbackend.dto.ElementUpdateDTO;
import com.app.techradarbackend.dto.ElementVersionUpdateDTO;
import com.app.techradarbackend.entity.ElementEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ElementMapper {
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "category.id", source = "categoryId")
    ElementEntity mapCreateDTOToEntity(ElementCreateDTO elementCreateDTO);

    @Mapping(target = "categoryId", source = "category.id")
    ElementDTO mapEntityToDTO(ElementEntity elementEntity);

    void mapUpdateDTOToEntity(ElementUpdateDTO elementUpdateDTO, @MappingTarget ElementEntity elementEntity);

    void mapStatusPatchDTOToEntity(ElementStatusUpdateDTO elementStatusUpdateDTO, @MappingTarget ElementEntity elementEntity);

    void mapLevelPatchDTOToEntity(ElementLevelUpdateDTO elementLevelUpdateDTO, @MappingTarget ElementEntity elementEntity);

    void mapVersionPatchDTOToEntity(ElementVersionUpdateDTO elementVersionUpdateDTO, @MappingTarget ElementEntity elementEntity);

    void mapCategoryPatchDTOToEntity(ElementCategoryUpdateDTO elementCategoryUpdateDTO, @MappingTarget ElementEntity elementEntity);

    List<ElementDTO> mapEntityListToDTOList(List<ElementEntity> elementList);
}
