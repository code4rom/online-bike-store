package com.bikestore.online_bike_store.service;

import com.bikestore.online_bike_store.model.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAllCategories();
    Optional<Category> findCategoryById(Long id);
    void saveCategory(Category category);
    void deleteCategoryById(Long id);
}
