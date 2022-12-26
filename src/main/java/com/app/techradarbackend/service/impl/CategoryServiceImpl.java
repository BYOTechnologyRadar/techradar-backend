package com.app.techradarbackend.service.impl;

import com.app.techradarbackend.dao.CategoryDAO;
import com.app.techradarbackend.dto.CategoryCreateAndUpdateDTO;
import com.app.techradarbackend.dto.CategoryDTO;
import com.app.techradarbackend.dto.CategoryRadarUpdateDTO;
import com.app.techradarbackend.dto.CategorySearchDTO;
import com.app.techradarbackend.entity.CategoryEntity;
import com.app.techradarbackend.entity.QCategoryEntity;
import com.app.techradarbackend.entity.RadarEntity;
import com.app.techradarbackend.exception.ResourceNotFoundException;
import com.app.techradarbackend.mapper.CategoryMapper;
import com.app.techradarbackend.service.CategoryService;
import com.app.techradarbackend.service.RadarService;
import com.querydsl.core.BooleanBuilder;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryDAO categoryDAO;
    private CategoryMapper categoryMapper;
    private RadarService radarService;

    @Autowired
    public CategoryServiceImpl(CategoryDAO categoryDAO, CategoryMapper categoryMapper, RadarService radarService) {
        this.categoryDAO = categoryDAO;
        this.categoryMapper = categoryMapper;
        this.radarService = radarService;
    }

    @Override
    public CategoryDTO addCategory(CategoryCreateAndUpdateDTO categoryCreateDTO) {
        CategoryEntity category = categoryMapper.mapCreateDTOToEntity(categoryCreateDTO);
        return categoryMapper.mapEntityToDTO(categoryDAO.save(category));
    }

    @Override
    public CategoryDTO addRadarToCategory(Integer categoryId, CategoryRadarUpdateDTO categoryRadarUpdateDTO) {
        CategoryEntity category = getById(categoryId);
        RadarEntity radar = radarService.getById(categoryRadarUpdateDTO.getRadarId());
        category.setRadar(radar);
        categoryMapper.mapRadarPatchDTOToEntity(categoryRadarUpdateDTO, category);
        return categoryMapper.mapEntityToDTO(categoryDAO.save(category));
    }

    @Override
    public CategoryDTO updateCategory(int categoryId, CategoryCreateAndUpdateDTO categoryUpdateDTO) {
        CategoryEntity category = getById(categoryId);
        categoryMapper.mapUpdateDTOToEntity(categoryUpdateDTO, category);
        return categoryMapper.mapEntityToDTO(categoryDAO.save(category));
    }

    @Override
    public CategoryDTO getCategoryById(int categoryId) {
        CategoryEntity category = getById(categoryId);
        return categoryMapper.mapEntityToDTO(category);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<CategoryEntity> categoryList = categoryDAO.findAll();
        return categoryMapper.mapEntityListToDTOList(categoryList);
    }

    @Override
    public List<CategoryDTO> searchCategoriesByName(CategorySearchDTO categorySearchDTO) {
        BooleanBuilder booleanBuilder = booleanBuilderForCategorySearch(categorySearchDTO);
        List<CategoryEntity> categoryList = (List<CategoryEntity>) categoryDAO.findAll(booleanBuilder);
        return categoryMapper.mapEntityListToDTOList(categoryList);
    }

    private BooleanBuilder booleanBuilderForCategorySearch(CategorySearchDTO categorySearchDTO) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QCategoryEntity qCategoryEntity = QCategoryEntity.categoryEntity;
        if (categorySearchDTO.getName() != null && !categorySearchDTO.getName().isEmpty()) {
            booleanBuilder.and(qCategoryEntity.name.containsIgnoreCase(categorySearchDTO.getName()));
        }
        return booleanBuilder;
    }

    @Override
    public List<CategoryDTO> getAllCategoriesByRadarId(int radarId) {
        RadarEntity radar = radarService.getById(radarId);
        List<CategoryEntity> categoryList = categoryDAO.getCategoryEntitiesByRadar(radar);
        return categoryMapper.mapEntityListToDTOList(categoryList);
    }

    @Override
    public CategoryEntity getById(int categoryId) {
        return categoryDAO.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category", "ID", categoryId));
    }

    @Override
    public void deleteCategoryById(int categoryId) {
        categoryDAO.deleteById(categoryId);
    }
}
