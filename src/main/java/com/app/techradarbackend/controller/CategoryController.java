package com.app.techradarbackend.controller;

import com.app.techradarbackend.configuration.SwaggerConfiguration;
import com.app.techradarbackend.dto.CategoryCreateAndUpdateDTO;
import com.app.techradarbackend.dto.CategoryDTO;
import com.app.techradarbackend.dto.CategorySearchDTO;
import com.app.techradarbackend.dto.ElementCategoryUpdateDTO;
import com.app.techradarbackend.dto.ElementDTO;
import com.app.techradarbackend.service.CategoryService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
@Api(tags = {SwaggerConfiguration.CATEGORY_TAG})
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping
    public CategoryDTO addCategory(@Valid @RequestBody CategoryCreateAndUpdateDTO categoryCreateDTO) {
        return categoryService.addCategory(categoryCreateDTO);
    }

    @PutMapping("/{categoryId}")
    public CategoryDTO updateCategory(@PathVariable Integer categoryId, @Valid @RequestBody CategoryCreateAndUpdateDTO categoryUpdateDTO) {
        return categoryService.updateCategory(categoryId, categoryUpdateDTO);
    }

    @PatchMapping("/element/{elementId}")
    ElementDTO updateElementCategory(@PathVariable Integer elementId, @Valid @RequestBody ElementCategoryUpdateDTO elementCategoryUpdateDTO) {
        return categoryService.updateElementCategory(elementId, elementCategoryUpdateDTO);
    }


    @GetMapping("/{categoryId}")
    public CategoryDTO getCategoryByCategoryId(@PathVariable Integer categoryId) {
        return categoryService.getCategoryByCategoryId(categoryId);
    }

    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/search")
    public List<CategoryDTO> searchCategoriesByCategoryName(@Valid @RequestBody CategorySearchDTO categorySearchDTO) {
        return categoryService.searchCategoriesByCategoryName(categorySearchDTO);
    }

    @GetMapping("/{categoryId}/elements")
    List<ElementDTO> getAllElementsByCategoryId(@PathVariable Integer categoryId) {
        return categoryService.getAllElementsByCategoryId(categoryId);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable Integer categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}
