package com.example.ps_project.repository;

import com.example.ps_project.entity.User;
import com.example.ps_project.jparepository.UserJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class UserRepository implements Repository{
    UserJpaRepository jpaRepositoryInt;

    public UserRepository(UserJpaRepository jpaRepositoryInt) {
        this.jpaRepositoryInt = jpaRepositoryInt;
    }

    @Override
    public List<Object> findAllItems() {
        return Collections.singletonList(jpaRepositoryInt.findAll());
    }

    @Override
    public void addItem(Object o) {
        User newUser = (User) o;
        jpaRepositoryInt.save(newUser);
    }

    @Override
    public void addItems(List<Object> objects) {
        List<User> users = (List<User>)(List<?>) objects;
        jpaRepositoryInt.saveAll(users);
    }
}
