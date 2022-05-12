package com.example.ps_project.jparepository;

import com.example.ps_project.entity.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public interface OrderListJpaRepository extends JpaRepository<OrderList,Long> {
}
