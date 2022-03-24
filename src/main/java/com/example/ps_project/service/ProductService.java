package com.example.ps_project.service;

import com.example.ps_project.entity.Product;
import com.example.ps_project.repository.ProductRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * The type Product service.
 */

//metodele GET si POST

@org.springframework.stereotype.Service
public class ProductService implements Service {

    private final ProductRepository productRepository;

    /**
     * Instantiates a new Product service.
     *
     * @param productRepository the product repository
     */
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Object> getItems() {
        return Collections.singletonList(productRepository.findAll());
    }

    @Override
    public void addNewItem(Object o) {
        Product newProduct = (Product)o;
        Optional<Product> productOptional = productRepository.findProductById(newProduct.getId());
        if(productOptional.isPresent()){
            throw new IllegalStateException("Product exists");
        }
        productRepository.save(newProduct);
    }
}
