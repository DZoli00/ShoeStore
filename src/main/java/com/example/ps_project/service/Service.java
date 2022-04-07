package com.example.ps_project.service;

import com.example.ps_project.entity.User;

import java.util.List;

public interface Service<T>{

    List<T> getItems();

    void addNewItem(T o);
}
