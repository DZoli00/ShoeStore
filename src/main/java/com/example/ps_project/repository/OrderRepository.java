package com.example.ps_project.repository;

import com.example.ps_project.entity.Order;
import com.example.ps_project.jparepository.OrderJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderRepository implements Repository<Order>{

    OrderJpaRepository jpaRepository;

    public OrderRepository(OrderJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Order> findAllItems() {
        return jpaRepository.findAll();
    }

    @Override
    public void addItem(Order o) {
        jpaRepository.save(o);
    }

    @Override
    public void addItems(List<Order> objects) {
        jpaRepository.saveAll(objects);
    }
}
