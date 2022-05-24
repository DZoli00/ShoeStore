package com.example.ps_project.controller;

import com.example.ps_project.entity.Category;
import com.example.ps_project.entity.Product;
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

    /**
     *
     * @return the list of the categories
     */
    @GetMapping
    public List<Category> getCategories(){ return categoryService.getItems();}

    @GetMapping(path="{id}")
    public List<Product> getProducts(@PathVariable("id") Long id){
        return categoryService.getProducts(id);
    }

    /**
     *
     * @return
     */
    public List<Category> getCategoriesCsv(){
        return categoryService.getItemsCSV();
    }

    /**
     * add a new category
     * @param category
     */
    @PostMapping
    public void registerNewCategory(@RequestBody Category category){categoryService.addNewItem(category);}

    /**
     * delete a category selected by Id
     * @param categoryId
     */
    @DeleteMapping(path= "{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId){
        categoryService.delete(categoryId);
    }

    /**
     * update a category selected byId
     * @param categoryId
     * @param name
     * @param description
     */
    @PutMapping(path="{categoryId}")
    public void update(
            @PathVariable("categoryId") Long categoryId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description
    ){
        categoryService.update(categoryId,name,description);
    }



}
