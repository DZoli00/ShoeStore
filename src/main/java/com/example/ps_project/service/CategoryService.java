package com.example.ps_project.service;

import com.example.ps_project.entity.Category;
import com.example.ps_project.repository.CategoryRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * The type Category service.
 */
//metodele din interfata implementate
//metoda GET si POST

@org.springframework.stereotype.Service
public class CategoryService implements Service {

    private final CategoryRepository categoryRepository;

    /**
     * Instantiates a new Category service.
     *
     * @param categoryRepository the category repository
     */
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Object> getItems() {
        return Collections.singletonList(categoryRepository.findAll());
    }

    @Override
    public void addNewItem(Object o) {
        Category newCategory = (Category)o;
        Optional<Category> categoryOptional = categoryRepository.findCategoriesByName(newCategory.getName());
        categoryRepository.save(newCategory);
    }
}
