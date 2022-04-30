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
import java.util.Optional;

/**
 * The type User service.
 */
//metodele GET, POST, PUT dupa id si DELETE dupa id

@org.springframework.stereotype.Service
public class UserService implements Service<User> {

    private final Repository userRepository;

    /**
     * Instantiates a new User service.
     *
     * @param userRepository the user repository
     */

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

//    /**
//     * Delete user.
//     *
//     * @param userId the user id
//     */
//    public void deleteUser(Long userId) {
//        boolean found = userRepository.existsById(userId);
//        if (!found) {
//            throw new IllegalStateException("User with this name " + userId + "does not exist");
//        }
//        userRepository.deleteById(userId);
//    }
//
//
   @Transactional
    public void update(Long userId, String firstName, String lastName, String email, String address){
        User user = (User) userRepository.findById(userId);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setAddress(address);
    }

}
