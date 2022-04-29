package com.example.ps_project.repository;

import com.example.ps_project.entity.Category;
import com.example.ps_project.jparepository.CategoryJpaRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryRepository implements Repository<Category>{
    CategoryJpaRepository jpaRepositoryInt;
    List<Category> categories = new ArrayList<Category>();

    public CategoryRepository(CategoryJpaRepository jpaRepositoryInt) {
        this.jpaRepositoryInt = jpaRepositoryInt;
    }

    @Override
    public List<Category> findAllItemsCSV() {
        return this.categories;
    }

    @Override
    public List<Category> findAllItems() {
        return jpaRepositoryInt.findAll();
    }

    @Override
    public void addItem(Category o) {
        jpaRepositoryInt.save(o);
        this.categories.add(o);
    }

    @Override
    public void addItems(List<Category> objects) {
        jpaRepositoryInt.saveAll(objects);
        this.categories.addAll(objects);
    }
}
