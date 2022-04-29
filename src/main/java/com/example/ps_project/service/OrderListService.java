package com.example.ps_project.service;

import com.example.ps_project.entity.OrderList;
import com.example.ps_project.repository.OrderListRepository;

import com.example.ps_project.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class OrderListService implements Service<OrderList>{

    private final Repository orderRepository;

    @Autowired
    public OrderListService(OrderListRepository orderListRepository) {
        this.orderRepository = orderListRepository;
    }

    @Override
    public List<OrderList> getItemsCSV() {
        return orderRepository.findAllItemsCSV();
    }

    @Override
    public List<OrderList> getItems() {
        return orderRepository.findAllItems();
    }

    @Override
    public void addNewItem(OrderList o) {
        orderRepository.addItem(o);
    }
}
