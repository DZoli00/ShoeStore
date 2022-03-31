package com.example.ps_project.repository;

import com.example.ps_project.entity.Product;
import com.example.ps_project.jparepository.ProductJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository implements Repository{
    ProductJpaRepository jpaRepositoryInt;

    @Autowired
    public ProductRepository(ProductJpaRepository jpaRepositoryInt) {
        this.jpaRepositoryInt = jpaRepositoryInt;
    }

    @Override
    public List<Object> findAllItems() {
        return Collections.singletonList(jpaRepositoryInt.findAll());
    }

    @Override
    public void addItem(Object o) {
        Product newProduct = (Product) o;
        jpaRepositoryInt.save(newProduct);
    }

    @Override
    public void addItems(List<Object> objects) {
        List<Product> products = (List<Product>)(List<?>) objects;
        jpaRepositoryInt.saveAll(products);
    }
}
