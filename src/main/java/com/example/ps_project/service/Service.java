package com.example.ps_project.service;

import com.example.ps_project.entity.User;

import java.util.List;

public interface Service{

    public abstract List<Object> getItems();

    public abstract void addNewItem(Object o);
}
