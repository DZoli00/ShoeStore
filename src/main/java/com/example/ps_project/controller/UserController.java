package com.example.ps_project.controller;

import com.example.ps_project.entity.FactoryUser;
import com.example.ps_project.entity.NormalUser;
import com.example.ps_project.entity.User;
import com.example.ps_project.entity.UserType;
import com.example.ps_project.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     *
     * @return the list of the users
     */
    //metoda GET
    @GetMapping
    public List<User> getUsers() {
        return userService.getItems();
    }

    /**
     *
     * @return the list of the users read from csv
     */
    @GetMapping(path="csv")
    public List<User> getUsersCSV() {
        return userService.getItemsCSV();
    }

    /**
     * add an Admin or a NormalUser to the User table, the type of the User is given as a PathVariable
     * @param user
     * @param type
     * @throws Exception
     */
    //metoda POST
    @PostMapping(path="{type}")
    public void registerNewUser(@RequestBody NormalUser user, @PathVariable("type") String type) throws Exception {
        User newUser = null;
        if (type.equals("ADMIN")) {
            newUser = factoryUser.create(UserType.ADMIN, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
        } else {
            if (type.equals("NORMALUSER"))
                newUser = factoryUser.create(UserType.NORMALUSER, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
        }
        if(newUser == null){
            throw new Exception("Invalid user");
        }
        userService.addNewItem(newUser);
    }

    /**
     * delete a user selected by userId
     * @param userId
     */
    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.delete(userId);
    }

    /**
     * update an user selected by userId
     * @param userId
     * @param first_name
     * @param last_name
     * @param email
     * @param address
     */
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
