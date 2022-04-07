package com.example.ps_project.controller;

import com.example.ps_project.entity.Category;
import com.example.ps_project.service.CategoryServiceCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryControllerCSV {

    private final CategoryServiceCSV categoryServiceCSV;

    @Autowired
    public CategoryControllerCSV(CategoryServiceCSV categoryServiceCSV) {
        this.categoryServiceCSV = categoryServiceCSV;
    }

    public List<Category> getCategories(){
        return categoryServiceCSV.getItems();
    }

    public void regiterNewCategory(Category category){
        categoryServiceCSV.addNewItem(category);
    }
}
