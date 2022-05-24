package com.example.ps_project.service;


import com.example.ps_project.entity.User;
import com.example.ps_project.repository.Repository;
import com.example.ps_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.transaction.Transactional;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * The type User service.
 */
//metodele GET, POST, PUT dupa id si DELETE dupa id

@org.springframework.stereotype.Service
public class UserService implements Service<User> {

    private final UserRepository userRepository;

    /**
     * Instantiates a new User service.
     *
     * @param userRepository the user repository
     */

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     *
     * @return
     */
    @Override
    public List<User> getItemsCSV() {
        return userRepository.findAllItemsCSV();
    }

    /**
     *
     * @return
     */
    @Override
    public List<User> getItems() {
        return userRepository.findAllItems();
    }

    /**
     *
     * @param o
     */
    @Override
    public void addNewItem(User o) {
        userRepository.addItem(o);
    }

    /**
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * update method for User
     * @param userId
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     */
   @Transactional
    public void update(Long userId, String firstName, String lastName, String email, String password){
        User user = (User) userRepository.findById(userId);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        userRepository.updateList(userId,firstName,lastName,email,password);
    }

}
