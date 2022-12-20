package com.app.techradarbackend.controller;

import com.app.techradarbackend.configuration.SwaggerConfiguration;
import com.app.techradarbackend.dto.CategoryCreateAndUpdateDTO;
import com.app.techradarbackend.dto.CategoryDTO;
import com.app.techradarbackend.dto.CategoryRadarUpdateDTO;
import com.app.techradarbackend.dto.CategorySearchDTO;
import com.app.techradarbackend.service.CategoryService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping
    public CategoryDTO addCategory(@Valid @RequestBody CategoryCreateAndUpdateDTO categoryCreateDTO) {
        return categoryService.addCategory(categoryCreateDTO);
    }

    @PatchMapping("/{categoryId}")
    CategoryDTO addRadarToCategory(@PathVariable Integer categoryId, @Valid @RequestBody CategoryRadarUpdateDTO categoryRadarUpdateDTO) {
        return categoryService.addRadarToCategory(categoryId, categoryRadarUpdateDTO);
    }

    @PutMapping("/{categoryId}")
    public CategoryDTO updateCategory(@PathVariable Integer categoryId, @Valid @RequestBody CategoryCreateAndUpdateDTO categoryUpdateDTO) {
        return categoryService.updateCategory(categoryId, categoryUpdateDTO);
    }

    @GetMapping("/{categoryId}")
    public CategoryDTO getCategoryById(@PathVariable Integer categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/radar/{radarId}")
    List<CategoryDTO> getAllCategoriesByRadarId(@PathVariable int radarId) {
        return categoryService.getAllCategoriesByRadarId(radarId);
    }

    @PostMapping("/search")
    public List<CategoryDTO> searchCategoriesByName(@Valid @RequestBody CategorySearchDTO categorySearchDTO) {
        return categoryService.searchCategoriesByName(categorySearchDTO);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategoryById(@PathVariable Integer categoryId) {
        categoryService.deleteCategoryById(categoryId);
    }
}
