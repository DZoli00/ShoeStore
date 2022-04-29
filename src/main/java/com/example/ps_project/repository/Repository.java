package com.example.ps_project.repository;

import java.util.List;

public interface Repository<T> {
    List<T> findAllItemsCSV();
    List<T> findAllItems();
    void addItem(T o);
    void addItems(List<T> objects);
}
