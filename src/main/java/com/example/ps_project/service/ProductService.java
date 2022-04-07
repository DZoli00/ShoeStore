package com.example.ps_project.service;

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

    @Override
    public List<Product> getItems() {
        return productRepository.findAllItems();
    }

    @Override
    public void addNewItem(Product o) {
        productRepository.addItem(o);
    }
}
