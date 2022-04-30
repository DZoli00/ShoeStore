package com.example.ps_project.repository;

import java.util.List;

public interface Repository<T> {
    List<T> findAllItemsCSV();
    List<T> findAllItems();
    void addItem(T o);
    void addItems(List<T> objects);

    boolean existsById(Long id);

    void deleteById(Long id);

    T findById(Long id);

    Long findByIdCSV(Long id);

}
