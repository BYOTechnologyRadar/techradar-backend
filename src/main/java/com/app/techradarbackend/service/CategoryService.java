package com.app.techradarbackend.service;

import com.app.techradarbackend.dto.CategoryCreateAndUpdateDTO;
import com.app.techradarbackend.dto.CategoryDTO;
import com.app.techradarbackend.dto.CategoryRadarUpdateDTO;
import com.app.techradarbackend.dto.CategorySearchDTO;
import com.app.techradarbackend.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {
    CategoryDTO addCategory(CategoryCreateAndUpdateDTO categoryCreateDTO);

    CategoryDTO addRadarToCategory(Integer categoryId, CategoryRadarUpdateDTO categoryRadarUpdateDTO);

    CategoryDTO updateCategory(int categoryId, CategoryCreateAndUpdateDTO categoryUpdateDTO);

    CategoryDTO getCategoryById(int categoryId);

    CategoryEntity getById(int categoryId);

    List<CategoryDTO> getAllCategories();

    List<CategoryDTO> searchCategoriesByName(CategorySearchDTO categorySearchDTO);

    List<CategoryDTO> getAllCategoriesByRadarId(int radarId);

    void deleteCategoryById(int categoryId);
}
