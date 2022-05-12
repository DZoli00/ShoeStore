package com.example.ps_project.service;

import com.example.ps_project.entity.OrderList;
import com.example.ps_project.entity.Product;
import com.example.ps_project.entity.User;
import com.example.ps_project.repository.OrderListRepository;

import com.example.ps_project.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class OrderListService implements Service<OrderList>{

    private final Repository orderRepository;


    /**
     *
     * @param orderListRepository
     */
    @Autowired
    public OrderListService(OrderListRepository orderListRepository) {
        this.orderRepository = orderListRepository;
    }

    /**
     *
     * @return
     */
    @Override
    public List<OrderList> getItemsCSV() {
        return orderRepository.findAllItemsCSV();
    }

    /**
     *
     * @return
     */
    @Override
    public List<OrderList> getItems() {
        return orderRepository.findAllItems();
    }

    /**
     *
     * @param o
     */
    @Override
    public void addNewItem(OrderList o) {
        orderRepository.addItem(o);
    }

    /**
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    /**
     * update method for OrderList
     * @param id
     * @param user
     * @param products
     * @param totalPrice
     * @param delivered
     */
    public void update(Long id, User user, List<Product> products, Float totalPrice, boolean delivered){
        OrderList orderList = (OrderList) orderRepository.findById(id);
        orderList.setUser(user);
        orderList.setProducts(products);
        orderList.setTotal_price(totalPrice);
        orderList.setDelivered(delivered);
    }
}
