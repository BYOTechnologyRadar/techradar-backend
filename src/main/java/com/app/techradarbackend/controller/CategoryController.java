package com.app.techradarbackend.controller;

import com.app.techradarbackend.entity.CategoryEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/techradar/api")
public class CategoryController {
    @PostMapping("/category")
    public CategoryEntity addCategory(@RequestBody CategoryEntity categoryEntity) {
        return null;
    }

    @PutMapping("/category")
    public CategoryEntity updateCategory(@RequestBody CategoryEntity categoryEntity) {
        return null;
    }

    @GetMapping("/category/{categoryId}")
    public CategoryEntity getCategoryByCategoryId(@PathVariable int categoryId) {
        return null;
    }

    @GetMapping("/categories")
    public List<CategoryEntity> getAllCategories() {
        return null;
    }

    @GetMapping("/categories/radarCategory/{radarCategoryId}")
    public List<CategoryEntity> getAllCategoriesByRadarCategoryId(@PathVariable int radarCategoryId) {
        return null;
    }

    @DeleteMapping("/category/{categoryId}")
    public void deleteCategoryByCategoryId(@PathVariable int categoryId) {
    }
}
