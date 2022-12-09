package com.app.techradarbackend.service;

import com.app.techradarbackend.dto.CategoryCreateAndUpdateDTO;
import com.app.techradarbackend.dto.CategoryDTO;
import com.app.techradarbackend.dto.CategorySearchDTO;
import com.app.techradarbackend.dto.ElementCategoryUpdateDTO;
import com.app.techradarbackend.dto.ElementDTO;
import com.app.techradarbackend.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {
    CategoryDTO addCategory(CategoryCreateAndUpdateDTO categoryCreateDTO);

    CategoryDTO updateCategory(int categoryId, CategoryCreateAndUpdateDTO categoryUpdateDTO);

    CategoryDTO getCategoryByCategoryId(int categoryId);

    CategoryEntity getByCategoryId(int categoryId);

    ElementDTO updateElementCategory(int elementId, ElementCategoryUpdateDTO elementCategoryUpdateDTO);

    List<CategoryDTO> getAllCategories();

    List<CategoryDTO> searchCategoriesByCategoryName(CategorySearchDTO categorySearchDTO);

    List<ElementDTO> getAllElementsByCategoryId(int categoryId);

    void deleteCategory(int categoryId);
}
