package com.example.ps_project.service;

import com.example.ps_project.entity.Category;
import com.example.ps_project.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The type Category service.
 */
//metodele din interfata implementate
//metoda GET si POST
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    /**
     * Instantiates a new Category service.
     *
     * @param categoryRepository the category repository
     */
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * Get categories list.
     *
     * @return list
     */
    public List<Category> getCategories(){ return categoryRepository.findAll();}

    /**
     * Add new category.
     *
     * @param category the category
     */
    public void addNewCategory(Category category){
        Optional<Category> categoryOptional = categoryRepository.findCategoriesByName(category.getName());
        categoryRepository.save(category);
    }
}
