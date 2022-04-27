package com.example.ps_project.controller;


import com.example.ps_project.entity.Category;
import com.example.ps_project.entity.Order;
import com.example.ps_project.service.OrderService;
import com.example.ps_project.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/order")
public class OrderController {

    private final Service orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getOrders(){ return orderService.getItems();}

    @PostMapping
    public void registerNewOrder(@RequestBody Order order){orderService.addNewItem(order);}
}
