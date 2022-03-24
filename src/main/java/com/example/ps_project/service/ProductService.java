package com.example.ps_project.service;

import com.example.ps_project.entity.Product;
import com.example.ps_project.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The type Product service.
 */
@Service
//metodele GET si POST
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * Instantiates a new Product service.
     *
     * @param productRepository the product repository
     */
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Gets products.
     *
     * @return products
     */
    public List<Product> getProducts() { return productRepository.findAll(); }

    /**
     * Add new product.
     *
     * @param product the product
     */
    public void addNewProduct(Product product){
        Optional<Product> productOptional = productRepository.findProductById(product.getId());
        if(productOptional.isPresent()){
            throw new IllegalStateException("Product exists");
        }
        productRepository.save(product);
    }
}
