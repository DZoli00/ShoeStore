package com.example.ps_project.controller;

import com.example.ps_project.entity.Category;
import com.example.ps_project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//metodele GET(read) si POST(creat) pentru product le avem implementate in aceasta clasa
@RestController
@RequestMapping(path="api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    
    @GetMapping
    public List<Category> getCategories(){ return categoryService.getCategories();}

    @PostMapping
    public void registerNewCategory(@RequestBody Category category){categoryService.addNewCategory(category);}
}
