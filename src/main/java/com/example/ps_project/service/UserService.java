package com.example.ps_project.service;


import com.example.ps_project.entity.User;
import com.example.ps_project.repository.UserRepository;

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
public class UserService implements Service {

    private final UserRepository userRepository;

    /**
     * Instantiates a new User service.
     *
     * @param userRepository the user repository
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Object> getItems() {
        return Collections.singletonList(userRepository.findAll());
    }

    @Override
    public void addNewItem(Object o) {
        User newUser = (User) o;
        userRepository.save(newUser);
    }

    /**
     * Delete user.
     *
     * @param userId the user id
     */
    public void deleteUser(Long userId) {
        boolean found = userRepository.existsById(userId);
        if (!found) {
            throw new IllegalStateException("User with this name " + userId + "does not exist");
        }
        userRepository.deleteById(userId);
    }


    /**
     * Update user.
     *
     * @param userId    the user id
     * @param firstName the first name
     * @param lastName  the last name
     * @param email     the email
     */
    @Transactional
    public void updateUser(Long userId, String firstName, String lastName, String email){
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("user with id " + userId + " doesn't exist"));
        if(firstName != null) {
            user.setFirst_name(firstName);
        }
        if(lastName != null) {
            user.setLast_name(lastName);
        }
        if(email != null) {
            user.setEmail(email);
        }
    }

}
