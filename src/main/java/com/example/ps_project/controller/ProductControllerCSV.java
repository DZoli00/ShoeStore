package com.example.ps_project.controller;

import com.example.ps_project.entity.Product;
import com.example.ps_project.service.ProductServiceCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductControllerCSV {
    private final ProductServiceCSV productServiceCSV;

    @Autowired
    public ProductControllerCSV(ProductServiceCSV productServiceCSV) {
        this.productServiceCSV = productServiceCSV;
    }

    public List<Product> getProducts(){
        return productServiceCSV.getItems();
    }

    public void registerNewProduct(Product product){
        productServiceCSV.addNewItem(product);
    }
}
