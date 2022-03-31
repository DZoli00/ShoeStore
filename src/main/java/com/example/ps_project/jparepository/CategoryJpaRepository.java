package com.example.ps_project.jparepository;

import com.example.ps_project.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<Category,Long> {
}
