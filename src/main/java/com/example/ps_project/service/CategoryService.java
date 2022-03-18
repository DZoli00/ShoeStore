package com.example.ps_project.service;

import com.example.ps_project.entity.Category;
import com.example.ps_project.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//metodele din interfata implementate
//metoda GET si POST
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories(){ return categoryRepository.findAll();}

    public void addNewCategory(Category category){
        Optional<Category> categoryOptional = categoryRepository.findCategoriesByName(category.getName());
        categoryRepository.save(category);
    }
}
