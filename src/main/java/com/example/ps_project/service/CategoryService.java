package com.example.ps_project.service;

import com.example.ps_project.entity.Category;
import com.example.ps_project.repository.CategoryRepository;
import com.example.ps_project.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * The type Category service.
 */
//metodele din interfata implementate
//metoda GET si POST

@org.springframework.stereotype.Service
public class CategoryService implements Service<Category> {

    private final Repository categoryRepository;

    /**
     * Instantiates a new Category service.
     *
     * @param categoryRepository the category repository
     */
    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getItemsCSV() {
        return categoryRepository.findAllItemsCSV();
    }

    @Override
    public List<Category> getItems() {
        return categoryRepository.findAllItems();
    }

    @Override
    public void addNewItem(Category o) {
        categoryRepository.addItem(o);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    @Transactional
    public void update(Long categoryId, String name, String description){
        Category category = (Category) categoryRepository.findById(categoryId);
        category.setName(name);
        category.setDescription(description);
    }
}
