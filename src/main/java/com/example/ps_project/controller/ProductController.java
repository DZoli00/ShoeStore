package com.example.ps_project.controller;

import com.example.ps_project.entity.Category;
import com.example.ps_project.entity.Product;
import com.example.ps_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//metodele GET(read) si POST(creat) pentru product le avem implementate in aceasta clasa
@RestController
@RequestMapping(path="api/v1/product")
public class ProductController {


    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     *
     * @return all the products from the PRoduct table
     */
    @GetMapping
    public List<Product> getProducts(){ return productService.getItems(); }

    /**
     *
     * @return all the product reads from CSV
     */
    public List<Product> getProductsCSV(){
        return productService.getItemsCSV();
    }

    /**
     * add a product to the Product table
     * @param product
     */
    @PostMapping
    public void registerNewProduct(@RequestBody Product product){productService.addNewItem(product);}

    /**
     * delete a product by id
     * @param productId
     */
    @DeleteMapping(path= "{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId){
        productService.delete(productId);
    }

    /**
     * update a product choosed by product_id
     * @param id
     * @param name
     * @param price
     * @param category
     * @param rating
     * @param description
     * @param color
     * @param brand
     */
    @PutMapping(path = "{id}")
    public void update(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Float price,
            @RequestParam(required = false) Category category,
            @RequestParam(required = false) Float rating,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) String brand
    ){
        productService.update(id,name,price,category,rating,description,color,brand);
    }
}
