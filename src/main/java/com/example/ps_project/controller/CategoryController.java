package com.example.ps_project.controller;

import com.example.ps_project.entity.Category;
import com.example.ps_project.service.CategoryService;
import com.example.ps_project.service.Service;
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
    public List<Category> getCategories(){ return categoryService.getItems();}

    public List<Category> getCategoriesCsv(){
        return categoryService.getItemsCSV();
    }

    @PostMapping
    public void registerNewCategory(@RequestBody Category category){categoryService.addNewItem(category);}

    @DeleteMapping(path= "{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId){
        categoryService.delete(categoryId);
    }

    @PutMapping(path="{categoryId}")
    public void update(
            @PathVariable("categoryId") Long categoryId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description
    ){
        categoryService.update(categoryId,name,description);
    }
}
