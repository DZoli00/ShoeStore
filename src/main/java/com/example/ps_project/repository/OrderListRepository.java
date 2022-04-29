package com.example.ps_project.repository;

import com.example.ps_project.entity.Category;
import com.example.ps_project.entity.OrderList;
import com.example.ps_project.jparepository.OrderListJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderListRepository implements Repository<OrderList>{

    OrderListJpaRepository jpaRepository;
    List<OrderList> orders = new ArrayList<OrderList>();

    @Autowired
    public OrderListRepository(OrderListJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<OrderList> findAllItemsCSV() {
        return this.orders;
    }

    @Override
    public List<OrderList> findAllItems() {
        return jpaRepository.findAll();
    }

    @Override
    public void addItem(OrderList o) {
        jpaRepository.save(o);
        this.orders.add(o);
    }

    @Override
    public void addItems(List<OrderList> objects) {
        jpaRepository.saveAll(objects);
        this.orders.addAll(objects);
    }
}
