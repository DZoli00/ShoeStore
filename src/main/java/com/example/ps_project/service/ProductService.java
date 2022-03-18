package com.example.ps_project.service;

import com.example.ps_project.entity.Product;
import com.example.ps_project.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//metodele GET si POST
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() { return productRepository.findAll(); }

    public void addNewProduct(Product product){
        Optional<Product> productOptional = productRepository.findProductById(product.getId());
        if(productOptional.isPresent()){
            throw new IllegalStateException("Product exists");
        }
        productRepository.save(product);

    }
}
