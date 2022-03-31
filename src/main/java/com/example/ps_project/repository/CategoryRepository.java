package com.example.ps_project.repository;

import com.example.ps_project.entity.Category;
import com.example.ps_project.jparepository.CategoryJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class CategoryRepository implements Repository{
    CategoryJpaRepository jpaRepositoryInt;

    public CategoryRepository(CategoryJpaRepository jpaRepositoryInt) {
        this.jpaRepositoryInt = jpaRepositoryInt;
    }

    @Override
    public List<Object> findAllItems() {
        return Collections.singletonList(jpaRepositoryInt.findAll());
    }

    @Override
    public void addItem(Object o) {
        Category newCategory = (Category) o;
        jpaRepositoryInt.save(newCategory);
    }

    @Override
    public void addItems(List<Object> objects) {
        List<Category> categories = (List<Category>)(List<?>) objects;
        jpaRepositoryInt.saveAll(categories);
    }
}
