package com.example.ps_project.repository;

import com.example.ps_project.entity.Product;
import com.example.ps_project.jparepository.ProductJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository implements Repository<Product>{
    ProductJpaRepository jpaRepositoryInt;

    List<Product> products = new ArrayList<Product>();

    @Autowired
    public ProductRepository(ProductJpaRepository jpaRepositoryInt) {
        this.jpaRepositoryInt = jpaRepositoryInt;
    }

    @Override
    public List<Product> findAllItemsCSV() {
        return this.products;
    }

    @Override
    public List<Product> findAllItems() {
        return jpaRepositoryInt.findAll();
    }

    @Override
    public void addItem(Product o) {
        jpaRepositoryInt.save(o);
        this.products.add(o);
    }

    @Override
    public void addItems(List<Product> objects) {
        jpaRepositoryInt.saveAll(objects);
        this.products.addAll(objects);
    }
}
