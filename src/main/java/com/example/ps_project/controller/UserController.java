package com.example.ps_project.controller;

import com.example.ps_project.entity.FactoryUser;
import com.example.ps_project.entity.NormalUser;
import com.example.ps_project.entity.User;
import com.example.ps_project.entity.UserType;
import com.example.ps_project.service.Service;
import com.example.ps_project.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

//in Controller implementam metodele/actiunile
@RestController
@RequestMapping(path = "api/v1/user")
@Getter
@Setter
public class UserController {

    FactoryUser factoryUser = new FactoryUser();

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    //metoda GET
    @GetMapping
    public List<User> getUsers() {
        return userService.getItems();
    }

    @GetMapping(path="csv")
    public List<User> getUsersCSV() {
        return userService.getItemsCSV();
    }

    //metoda POST
    @PostMapping(path="{type}")
    public void registerNewUser(@RequestBody NormalUser user, @PathVariable("type") String type) throws Exception {
        User newUser = null;
        if (type.equals("ADMIN")) {
            newUser = factoryUser.create(UserType.ADMIN, user.getFirstName(), user.getLastName(), user.getEmail(), user.getAddress());
        } else {
            if (type.equals("NORMALUSER"))
                newUser = factoryUser.create(UserType.NORMALUSER, user.getFirstName(), user.getLastName(), user.getEmail(), user.getAddress());
        }
        if(newUser == null){
            throw new Exception("Invalid user");
        }
        userService.addNewItem(newUser);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.delete(userId);
    }


    @PutMapping(path = "{userId}")
    public void updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String first_name,
            @RequestParam(required = false) String last_name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String address) {
        userService.update(userId, first_name, last_name, email, address);
    }
}
