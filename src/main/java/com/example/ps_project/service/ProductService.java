package com.example.ps_project.service;

import com.example.ps_project.entity.Category;
import com.example.ps_project.entity.Product;
import com.example.ps_project.repository.ProductRepository;
import com.example.ps_project.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * The type Product service.
 */

//metodele GET si POST

@org.springframework.stereotype.Service
public class ProductService implements Service<Product>{

    private final Repository productRepository;

    /**
     * Instantiates a new Product service.
     *
     * @param productRepository the product repository
     */
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    /**
     *
     * @return
     */
    @Override
    public List<Product> getItemsCSV() {
        return productRepository.findAllItemsCSV();
    }

    /**
     *
     * @return
     */
    @Override
    public List<Product> getItems() {
        return productRepository.findAllItems();
    }

    /**
     *
     * @param o
     */
    @Override
    public void addNewItem(Product o) {
        productRepository.addItem(o);
    }

    /**
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }


    /**
     * update method for Product
     * @param id
     * @param name
     * @param price
     * @param category
     * @param rating
     * @param description
     * @param color
     * @param brand
     */
    public void update(Long id, String name, Float price, Category category, Float rating, String description, String color, String brand){
        Product product = (Product) productRepository.findById(id);
        product.setName(name);
        product.setPrice(price);
        product.setCategory(category);
        product.setRating(rating);
        product.setDescription(description);
        product.setColor(color);
        product.setBrand(brand);

    }
}
