package com.example.ps_project.repository;

import com.example.ps_project.entity.Category;
import com.example.ps_project.entity.OrderList;
import com.example.ps_project.jparepository.OrderListJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * the Repository for the Order entity, it contains and implements the same methods as the Controller class
 */
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

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
        for(OrderList ord: orders){
            if(ord.getId().equals(id)){
                orders.remove(ord);
                return;
            }
        }
    }

    @Override
    public OrderList findById(Long id) {
        return jpaRepository.getById(id);
    }

    @Override
    public Long findByIdCSV(Long id) {
        for(OrderList ord: orders){
            if(ord.getId().equals(id)){
                return id;
            }
        }
        return null;
    }

}
