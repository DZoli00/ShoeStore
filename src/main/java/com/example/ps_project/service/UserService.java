package com.example.ps_project.service;


import com.example.ps_project.entity.User;
import com.example.ps_project.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * The type User service.
 */
//metodele GET, POST, PUT dupa id si DELETE dupa id
@Service
public class UserService {

    private final UserRepository userRepository;

    /**
     * Instantiates a new User service.
     *
     * @param userRepository the user repository
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Get users list.
     *
     * @return list
     */
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    /**
     * Add new user.
     *
     * @param user the user
     */
    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUsersByEmail(user.getEmail());
        if(userOptional.isPresent()){
            throw new IllegalStateException("Email taken.");
        }
        userRepository.save(user);
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
