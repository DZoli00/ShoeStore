package com.example.ps_project.repository;

import com.example.ps_project.entity.User;
import com.example.ps_project.jparepository.UserJpaRepository;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class UserRepository implements Repository<User>{
    UserJpaRepository jpaRepositoryInt;

    public UserRepository(UserJpaRepository jpaRepositoryInt) {
        this.jpaRepositoryInt = jpaRepositoryInt;
    }

    @Override
    public List<User> findAllItems() {
        return jpaRepositoryInt.findAll();
    }

    @Override
    public void addItem(User o) {
        jpaRepositoryInt.save(o);
    }

    @Override
    public void addItems(List<User> objects) {
        jpaRepositoryInt.saveAll(objects);
    }
}
