package com.example.ps_project.controller;


import com.example.ps_project.entity.OrderList;
import com.example.ps_project.entity.Product;
import com.example.ps_project.entity.User;
import com.example.ps_project.service.OrderListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/orderlist")
public class OrderListController {

    private final OrderListService orderListService;

    public OrderListController(OrderListService orderListService) {
        this.orderListService = orderListService;
    }

    /**
     * @return all the orders from the OrderList table
     */
    @GetMapping
    public List<OrderList> getOrders(){ return orderListService.getItems();}

    /**
     *
     * @return all the orders reads from CSV
     */
    public List<OrderList> getOrdersCSV(){
        return orderListService.getItemsCSV();
    }

    /**
     *
     * @param orderList add a new Order to the table
     */
    @PostMapping
    public void registerNewOrder(@RequestBody OrderList orderList){orderListService.addNewItem(orderList);}

    /**
     *
     * @param orderId delete an order by orderId
     */
    @DeleteMapping(path= "{orderId}")
    public void deleteOrderList(@PathVariable("orderId") Long orderId){
        orderListService.delete(orderId);
    }

    /**
     * update an Order selected by id
     * @param id
     * @param user
     * @param products
     * @param totalPrice
     * @param delivered
     */
    @PutMapping(path = "{id}")
    public void update(
            @PathVariable("id") Long id,
            @RequestParam(required = false) User user,
            @RequestParam(required = false) List<Product> products,
            @RequestParam(required = false) Float totalPrice,
            @RequestParam(required = false) boolean delivered
    ){
        orderListService.update(id,user,products,totalPrice,delivered);
    }
}
