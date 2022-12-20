package com.app.techradarbackend.mapper;

import com.app.techradarbackend.dataProvider.CategoryDataProvider;
import com.app.techradarbackend.dto.CategoryCreateAndUpdateDTO;
import com.app.techradarbackend.dto.CategoryDTO;
import com.app.techradarbackend.entity.CategoryEntity;
import org.mockito.InjectMocks;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CategoryMapperTests {
    @InjectMocks
    private CategoryMapper categoryMapper = new CategoryMapperImpl();

    @Test(dataProvider = "getCategoryEntity", dataProviderClass = CategoryDataProvider.class)
    public void CM_01_mapEntityToDTO(final CategoryEntity categoryEntity) {
        CategoryDTO categoryDTO = categoryMapper.mapEntityToDTO(categoryEntity);

        assertEquals(categoryDTO.getId(), categoryEntity.getId());
        assertEquals(categoryDTO.getName(), categoryEntity.getName());
        assertEquals(categoryDTO.getRadarId(), categoryEntity.getRadar().getId());
        assertEquals(categoryDTO.getDescription(), categoryEntity.getDescription());
    }

    @Test(dataProvider = "getCategoryCreateDTO", dataProviderClass = CategoryDataProvider.class)
    public void CM_02_mapCreateDTOToEntity(final CategoryCreateAndUpdateDTO categoryCreateDTO) {
        CategoryEntity categoryEntity = categoryMapper.mapCreateDTOToEntity(categoryCreateDTO);

        assertEquals(categoryEntity.getName(), categoryCreateDTO.getName());
        assertEquals(categoryEntity.getDescription(), categoryCreateDTO.getDescription());
    }
}
