package com.example.ps_project.repository;

import java.util.List;

public interface Repository {
    List<Object> findAllItems();
    void addItem(Object o);
    void addItems(List<Object> objects);
}
