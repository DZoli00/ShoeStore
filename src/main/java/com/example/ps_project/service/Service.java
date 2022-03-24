package com.example.ps_project.service;

import java.util.List;

public interface Service{

    public abstract List<Object> getItems();

    public abstract void addNewItem(Object o);
}
