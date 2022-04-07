package com.example.ps_project.repository;

import com.example.ps_project.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryCSV implements Repository<Category> {

    List<Category> categories = new ArrayList<Category>();

    @Override
    public List<Category> findAllItems() {
        return this.categories;
    }

    @Override
    public void addItem(Category o) {
        this.categories.add(o);
    }

    @Override
    public void addItems(List<Category> objects) {
        this.categories.addAll(objects);
    }
}
