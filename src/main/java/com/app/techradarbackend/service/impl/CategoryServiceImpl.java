package com.app.techradarbackend.service.impl;

import com.app.techradarbackend.dao.CategoryDAO;
import com.app.techradarbackend.dao.ElementDAO;
import com.app.techradarbackend.dto.CategoryCreateAndUpdateDTO;
import com.app.techradarbackend.dto.CategoryDTO;
import com.app.techradarbackend.dto.CategorySearchDTO;
import com.app.techradarbackend.dto.ElementCategoryUpdateDTO;
import com.app.techradarbackend.dto.ElementDTO;
import com.app.techradarbackend.entity.CategoryEntity;
import com.app.techradarbackend.entity.ElementEntity;
import com.app.techradarbackend.entity.QCategoryEntity;
import com.app.techradarbackend.exception.ResourceNotFoundException;
import com.app.techradarbackend.mapper.CategoryMapper;
import com.app.techradarbackend.mapper.ElementMapper;
import com.app.techradarbackend.service.CategoryService;
import com.app.techradarbackend.service.ElementService;
import com.querydsl.core.BooleanBuilder;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryDAO categoryDAO;
    private CategoryMapper categoryMapper;
    private ElementDAO elementDAO;
    private ElementService elementService;
    private ElementMapper elementMapper;

    @Autowired
    public CategoryServiceImpl(CategoryDAO categoryDAO, CategoryMapper categoryMapper, @Lazy ElementDAO elementDAO, @Lazy ElementService elementService, ElementMapper elementMapper) {
        this.categoryDAO = categoryDAO;
        this.categoryMapper = categoryMapper;
        this.elementDAO = elementDAO;
        this.elementService = elementService;
        this.elementMapper = elementMapper;
    }

    @Override
    public CategoryDTO addCategory(CategoryCreateAndUpdateDTO categoryCreateDTO) {
        CategoryEntity category = categoryMapper.mapCreateDTOToEntity(categoryCreateDTO);
        return categoryMapper.mapEntityToDTO(categoryDAO.save(category));
    }

    @Override
    public CategoryDTO updateCategory(int categoryId, CategoryCreateAndUpdateDTO categoryUpdateDTO) {
        CategoryEntity category = getByCategoryId(categoryId);
        categoryMapper.mapUpdateDTOToEntity(categoryUpdateDTO, category);
        return categoryMapper.mapEntityToDTO(categoryDAO.save(category));
    }

    @Override
    public CategoryDTO getCategoryByCategoryId(int categoryId) {
        CategoryEntity category = getByCategoryId(categoryId);
        return categoryMapper.mapEntityToDTO(category);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<CategoryEntity> categoryList = categoryDAO.findAll();
        return categoryMapper.mapEntityListToDTOList(categoryList);
    }

    @Override
    public List<CategoryDTO> searchCategoriesByCategoryName(CategorySearchDTO categorySearchDTO) {
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
    public List<ElementDTO> getAllElementsByCategoryId(int categoryId) {
        CategoryEntity category = getByCategoryId(categoryId);
        List<ElementEntity> elementList = elementDAO.getElementEntitiesByCategory(category);
        return elementMapper.mapEntityListToDTOList(elementList);
    }

    @Override
    public CategoryEntity getByCategoryId(int categoryId) {
        return categoryDAO.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category", "ID", categoryId));
    }

    @Override
    public ElementDTO updateElementCategory(int elementId, ElementCategoryUpdateDTO elementCategoryUpdateDTO) {
        ElementEntity element = elementService.getByElementId(elementId);
        CategoryEntity category = getByCategoryId(elementCategoryUpdateDTO.getCategoryId());
        element.setCategory(category);
        elementMapper.mapCategoryPatchDTOToEntity(elementCategoryUpdateDTO, element);
        return elementMapper.mapEntityToDTO(elementDAO.save(element));
    }

    @Override
    public void deleteCategory(int categoryId) {
        categoryDAO.deleteById(categoryId);
    }
}
