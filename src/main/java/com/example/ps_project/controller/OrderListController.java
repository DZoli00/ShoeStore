package com.example.ps_project.controller;


import com.example.ps_project.entity.OrderList;
import com.example.ps_project.service.OrderListService;
import com.example.ps_project.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/orderlist")
public class OrderListController {

    private final Service orderService;

    @Autowired
    public OrderListController(OrderListService orderListService) {
        this.orderService = orderListService;
    }

    @GetMapping
    public List<OrderList> getOrders(){ return orderService.getItems();}

    public List<OrderList> getOrdersCSV(){
        return orderService.getItemsCSV();
    }

    @PostMapping
    public void registerNewOrder(@RequestBody OrderList orderList){orderService.addNewItem(orderList);}
}
