package com.example.ps_project.controller;

import com.example.ps_project.entity.Product;
import com.example.ps_project.service.ProductService;
import com.example.ps_project.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//metodele GET(read) si POST(creat) pentru product le avem implementate in aceasta clasa
@RestController
@RequestMapping(path="api/v1/product")
public class ProductController {

    private final Service productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Object> getProducts(){ return productService.getItems(); }

    @PostMapping
    public void registerNewProduct(@RequestBody Product product){productService.addNewItem(product);}
}
