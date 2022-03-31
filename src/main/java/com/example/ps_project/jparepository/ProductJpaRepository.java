package com.example.ps_project.jparepository;

import com.example.ps_project.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductJpaRepository extends JpaRepository<Product,Long> {
}
