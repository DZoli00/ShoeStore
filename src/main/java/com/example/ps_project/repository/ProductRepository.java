package com.example.ps_project.repository;

import com.example.ps_project.entity.Category;
import com.example.ps_project.entity.Product;
import com.example.ps_project.jparepository.ProductJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * the Repository for the Product entity, it contains and implements the same methods as the Controller class
 */
@Component
public class ProductRepository implements Repository<Product> {
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

    @Override
    public boolean existsById(Long id) {
        return jpaRepositoryInt.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepositoryInt.deleteById(id);
        for (Product prod : products) {
            if (prod.getId().equals(id)) {
                products.remove(prod);
                return;
            }
        }
    }

    @Override
    public Product findById(Long id) {
        return jpaRepositoryInt.getById(id);
    }

    @Override
    public Long findByIdCSV(Long id) {
        for (Product prod : products) {
            if (prod.getId().equals(id)) {
                return id;
            }
        }
        return null;
    }

}
