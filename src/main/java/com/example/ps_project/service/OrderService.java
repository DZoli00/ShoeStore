package com.example.ps_project.service;

import com.example.ps_project.entity.Order;
import com.example.ps_project.repository.OrderRepository;

import com.example.ps_project.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class OrderService implements Service<Order>{

    private final Repository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getItems() {
        return orderRepository.findAllItems();
    }

    @Override
    public void addNewItem(Order o) {
        orderRepository.addItem(o);
    }
}
