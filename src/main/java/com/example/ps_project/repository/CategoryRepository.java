package com.example.ps_project.repository;

import com.example.ps_project.entity.Category;
import com.example.ps_project.jparepository.CategoryJpaRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CategoryRepository implements Repository<Category> {
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

    @Override
    public boolean existsById(Long id) {
        return jpaRepositoryInt.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepositoryInt.deleteById(id);
        for(Category cat: categories){
            if(cat.getId().equals(id)){
                categories.remove(cat);
                return;
            }
        }
    }

    @Override
    public Category findById(Long id) {
         return jpaRepositoryInt.getById(id);
    }

    @Override
    public Long findByIdCSV(Long id) {
        for(Category cat: categories){
            if(cat.getId().equals(id)){
                return id;
            }
        }
        return null;
    }


}
