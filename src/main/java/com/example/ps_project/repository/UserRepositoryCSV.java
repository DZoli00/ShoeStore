package com.example.ps_project.repository;

import com.example.ps_project.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
public class UserRepositoryCSV implements Repository<User>{

    List<User> users = new ArrayList<User>();

    @Override
    public List<User> findAllItems() {
        return this.users;
    }

    @Override
    public void addItem(User o) {
        this.users.add(o);
    }

    @Override
    public void addItems(List<User> objects) {
        this.users.addAll(objects);
    }
}
