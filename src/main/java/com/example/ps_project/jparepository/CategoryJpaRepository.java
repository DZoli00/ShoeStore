package com.example.ps_project.jparepository;

import com.example.ps_project.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public interface CategoryJpaRepository extends JpaRepository<Category,Long> {
}
