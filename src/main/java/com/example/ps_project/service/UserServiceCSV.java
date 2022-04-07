package com.example.ps_project.service;

import com.example.ps_project.entity.User;
import com.example.ps_project.repository.UserRepositoryCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceCSV implements Service<User>{

    private final UserRepositoryCSV userRepositoryCSV;

    @Autowired
    public UserServiceCSV(UserRepositoryCSV userRepositoryCSV) {
        this.userRepositoryCSV = userRepositoryCSV;
    }

    @Override
    public List<User> getItems() {
        return userRepositoryCSV.findAllItems();
    }

    @Override
    public void addNewItem(User o) {
        userRepositoryCSV.addItem(o);
    }
}
