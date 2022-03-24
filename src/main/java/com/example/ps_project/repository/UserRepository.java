package com.example.ps_project.repository;

import com.example.ps_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    //cautare dupa email
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    // SELECT * from User where email = ?;
    Optional<User> findUsersByEmail(String email);
}
