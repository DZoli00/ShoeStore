package com.example.ps_project.repository;

import com.example.ps_project.laborator.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryCSV implements Repository<User>{

    List<User> users = new ArrayList<User>();

    @Override
    public List<User> findAllItems() {
        return this.users;
    }

    @Override
    public void addItem(User o) {
        this.users.add(o);
    }

    @Override
    public void addItems(List<User> objects) {
        this.users.addAll(objects);
    }
}
