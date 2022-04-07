package com.example.ps_project.service;

import com.example.ps_project.entity.Product;
import com.example.ps_project.repository.ProductRepositoryCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceCSV implements Service<Product> {

    private final ProductRepositoryCSV productRepositoryCSV;

    @Autowired
    public ProductServiceCSV(ProductRepositoryCSV productRepositoryCSV) {
        this.productRepositoryCSV = productRepositoryCSV;
    }

    @Override
    public List<Product> getItems() {
        return productRepositoryCSV.findAllItems();
    }

    @Override
    public void addNewItem(Product o) {
        productRepositoryCSV.addItem(o);
    }
}
