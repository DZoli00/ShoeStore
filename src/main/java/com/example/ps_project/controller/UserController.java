package com.example.ps_project.controller;

import com.example.ps_project.entity.User;
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
@RequestMapping(path="api/v1/user")
@Getter
@Setter
public class UserController {

    private final Service userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    //metoda GET
    @GetMapping
    public List<User> getUsers(){ return userService.getItems();}

    public List<User> getUsersCSV(){
        return userService.getItemsCSV();
    }
    //metoda POST
    @PostMapping
    public void registerNewUser(@RequestBody User user){

        userService.addNewItem(user);
    }

    /*//metoda DELETE dupa id
    @DeleteMapping(path= "{useId}")
    public void deleteUser(@PathVariable("useId") Long useId){
        userService.deleteUser(useId);
    }

    //metoda PUT(update) dupa id
    @PutMapping(path = "{userId}")
    public void updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String first_name,
            @RequestParam(required = false) String last_name,
            @RequestParam(required = false) String email){
        userService.updateUser(userId, first_name, last_name, email);
    }*/
}
