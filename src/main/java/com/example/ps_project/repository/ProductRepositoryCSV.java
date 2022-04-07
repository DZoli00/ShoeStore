package com.example.ps_project.repository;

import com.example.ps_project.entity.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
public class ProductRepositoryCSV implements Repository<Product>{

    List<Product> products = new ArrayList<Product>();

    @Override
    public List<Product> findAllItems() {
        return this.products;
    }

    @Override
    public void addItem(Product o) {
        this.products.add(o);
    }

    @Override
    public void addItems(List<Product> objects) {
        this.products.addAll(objects);
    }
}
