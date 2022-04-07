package com.example.ps_project.service;

import com.example.ps_project.entity.Category;
import com.example.ps_project.repository.CategoryRepositoryCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryServiceCSV implements Service<Category>{

    private final CategoryRepositoryCSV categoryRepositoryCSV;

    @Autowired
    public CategoryServiceCSV(CategoryRepositoryCSV categoryRepositoryCSV) {
        this.categoryRepositoryCSV = categoryRepositoryCSV;
    }

    @Override
    public List<Category> getItems() {
        return categoryRepositoryCSV.findAllItems();
    }

    @Override
    public void addNewItem(Category o) {
        categoryRepositoryCSV.addItem(o);
    }
}
