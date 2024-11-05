package com.bikestore.online_bike_store.controller;

import com.bikestore.online_bike_store.model.Category;
import com.bikestore.online_bike_store.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    // Constructor-based dependency injection for the CategoryService.
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Endpoint to retrieve all categories.
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.findAllCategories();
    }

    // Endpoint to retrieve a category by ID.
    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id) {
        return categoryService.findCategoryById(id);
    }

    // Endpoint to create or update a category.
    @PostMapping
    public void saveCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
    }

    // Endpoint to delete a category by ID.
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);
    }
}
