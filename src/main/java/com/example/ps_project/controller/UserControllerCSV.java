package com.example.ps_project.controller;

import com.example.ps_project.entity.User;
import com.example.ps_project.service.UserServiceCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserControllerCSV {
    private final UserServiceCSV userServiceCSV;

    @Autowired
    public UserControllerCSV(UserServiceCSV userServiceCSV) {
        this.userServiceCSV = userServiceCSV;
    }

    public List<User> getUsers(){
        return userServiceCSV.getItems();
    }

    public void registerNewUser(User user){
        userServiceCSV.addNewItem(user);
    }
}
