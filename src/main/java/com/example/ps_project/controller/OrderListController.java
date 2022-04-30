package com.example.ps_project.controller;


import com.example.ps_project.entity.OrderList;
import com.example.ps_project.entity.Product;
import com.example.ps_project.entity.User;
import com.example.ps_project.service.OrderListService;
import com.example.ps_project.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/orderlist")
public class OrderListController {

    private final OrderListService orderService;

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

    @DeleteMapping(path= "{orderId}")
    public void deleteOrderList(@PathVariable("orderId") Long orderId){
        orderService.delete(orderId);
    }

    @PutMapping(path = "{id}")
    public void update(
            @PathVariable("id") Long id,
            @RequestParam(required = false) User user,
            @RequestParam(required = false) List<Product> products,
            @RequestParam(required = false) Float totalPrice,
            @RequestParam(required = false) boolean delivered
    ){
        orderService.update(id,user,products,totalPrice,delivered);
    }
}
