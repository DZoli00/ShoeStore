package com.example.ps_project.repository;

import com.example.ps_project.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//interfata pentru category, aici avem toate actiunile care trebuie implementate
//avem un QUERY care face cautare dupa numa
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

        @Query("SELECT c FROM Category c WHERE c.name=?1")
        Optional<Category> findCategoriesByName(String name);
}
