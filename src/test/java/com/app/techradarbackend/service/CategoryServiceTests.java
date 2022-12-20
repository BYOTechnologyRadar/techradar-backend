package com.app.techradarbackend.service;

import com.app.techradarbackend.dao.CategoryDAO;
import com.app.techradarbackend.dataProvider.CategoryDataProvider;
import com.app.techradarbackend.dto.CategoryCreateAndUpdateDTO;
import com.app.techradarbackend.dto.CategoryDTO;
import com.app.techradarbackend.entity.CategoryEntity;
import com.app.techradarbackend.mapper.CategoryMapper;
import com.app.techradarbackend.mapper.CategoryMapperImpl;
import com.app.techradarbackend.service.impl.CategoryServiceImpl;
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

public class CategoryServiceTests {
    @Mock
    private CategoryDAO categoryDAO;

    @InjectMocks
    private CategoryService categoryService;

    @Spy
    private CategoryMapper categoryMapper = new CategoryMapperImpl();

    @BeforeClass
    public void initMock() {
        categoryService = new CategoryServiceImpl();
        MockitoAnnotations.openMocks(this);
    }

    @Test(dataProvider = "getCategoryCreateAndUpdateDTOAndCategoryEntityAndCategoryDTO", dataProviderClass = CategoryDataProvider.class)
    public void CS_01_Add_Category_Successful(CategoryCreateAndUpdateDTO categoryCreateDTO, CategoryEntity categoryEntity, CategoryDTO categoryDTO) {
        when(categoryMapper.mapCreateDTOToEntity(categoryCreateDTO)).thenReturn(categoryEntity);
        when(categoryDAO.save(categoryEntity)).thenReturn(categoryEntity);
        when(categoryService.addCategory(categoryCreateDTO)).thenReturn(categoryDTO);
        when(categoryMapper.mapEntityToDTO(categoryEntity)).thenReturn(categoryDTO);

        final CategoryDTO category = categoryService.addCategory(categoryCreateDTO);
        Assert.assertNotNull(category);
    }

    @Test(dataProvider = "getCategoryCreateAndUpdateDTOAndCategoryEntityAndCategoryDTO", dataProviderClass = CategoryDataProvider.class)
    public void CS_02_Update_Category_Successful(CategoryCreateAndUpdateDTO categoryCreateAndUpdateDTO, CategoryEntity categoryEntity, CategoryDTO categoryDTO) {
        when(categoryDAO.findById(1)).thenReturn(Optional.of(categoryEntity));
        when(categoryService.updateCategory(1, categoryCreateAndUpdateDTO)).thenReturn(categoryDTO);

        verify(categoryMapper, times(1)).mapUpdateDTOToEntity(categoryCreateAndUpdateDTO, categoryEntity);
    }

    @Test(dataProvider = "getCategoryEntityListAndCategoryDTOList", dataProviderClass = CategoryDataProvider.class)
    public void CS_03_Get_All_Categories_Successful(List<CategoryEntity> categoryEntityList, List<CategoryDTO> categoryDTOList) {
        when(categoryDAO.findAll()).thenReturn(categoryEntityList);
        when(categoryService.getAllCategories()).thenReturn(categoryDTOList);

        verify(categoryDAO, times(1)).findAll();
    }

    @Test(dataProvider = "getCategoryEntityAndCategoryDTO", dataProviderClass = CategoryDataProvider.class)
    public void CS_04_Get_Category_Successful(CategoryEntity categoryEntity, CategoryDTO categoryDTO) {
        when(categoryDAO.findById(1)).thenReturn(Optional.of(categoryEntity));
        when(categoryService.getCategoryById(1)).thenReturn(categoryDTO);

        final CategoryDTO category = categoryService.getCategoryById(1);
        Assert.assertNotNull(category);
    }

    @Test
    public void CS_05_Delete_Category_Successful() {
        categoryService.deleteCategoryById(1);

        verify(categoryDAO, times(1)).deleteById(1);
    }
}
