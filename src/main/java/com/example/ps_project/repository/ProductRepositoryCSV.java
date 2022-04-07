package com.example.ps_project.repository;

import com.example.ps_project.entity.Product;

import java.util.List;

public class ProductRepositoryCSV implements Repository<Product>{
    @Override
    public List<Product> findAllItems() {
        return null;
    }

    @Override
    public void addItem(Product o) {

    }

    @Override
    public void addItems(List<Product> objects) {

    }
}
