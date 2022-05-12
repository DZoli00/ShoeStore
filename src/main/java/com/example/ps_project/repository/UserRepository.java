package com.example.ps_project.repository;

import com.example.ps_project.entity.*;
import com.example.ps_project.jparepository.UserJpaRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * the Repository for the User entity, it contains and implements the same methods as the Controller class
 */
@Component
public class UserRepository implements Repository<User> {
    UserJpaRepository jpaRepositoryInt;
    List<User> users = new ArrayList<User>();

    public UserRepository(UserJpaRepository jpaRepositoryInt) {
        this.jpaRepositoryInt = jpaRepositoryInt;
    }

    @Override
    public List<User> findAllItemsCSV() {

        for(User user: users){
            System.out.println(user.getFirstName() + " " + user.getLastName() + " " +user.getEmail() + " " + user.getAddress() + " " + user.getClass());
        }
        System.out.println();
        return this.users;
    }

    @Override
    public List<User> findAllItems() {
        return jpaRepositoryInt.findAll();
    }

    @Override
    public void addItem(User o) {
        jpaRepositoryInt.save(o);
        this.users.add(o);
    }

    @Override
    public void addItems(List<User> objects) {
        jpaRepositoryInt.saveAll(objects);
        this.users.addAll(objects);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepositoryInt.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepositoryInt.deleteById(id);
        for (User usr : users) {
            if (usr.getId().equals(id)) {
                users.remove(usr);
                return;
            }
        }
    }

    @Override
    public User findById(Long id) {
        return jpaRepositoryInt.getById(id);
    }

    @Override
    public Long findByIdCSV(Long id) {
        for (User usr : users) {
            if (usr.getId().equals(id)) {
                return id;
            }
        }
        return null;
    }

    public void updateList(Long id, String firstName, String lastName, String email, String address) {
        for (User usr : users) {
            System.out.println(usr.getId());
            if (usr.getId().equals(id)) {
                List <OrderList> orders = usr.getOrderLists();
                FactoryUser factoryUser = new FactoryUser();
                if(usr.getClass().equals(Admin.class)){
                    User newUser =  factoryUser.create(UserType.ADMIN, firstName,lastName,email,address);
                    newUser.setId(usr.getId());
                    users.set(Math.toIntExact(usr.getId()),newUser);

                } else{
                    User newUser =  factoryUser.create(UserType.NORMALUSER, firstName,lastName,email,address);
                    newUser.setId(usr.getId());
                    users.set(Math.toIntExact(usr.getId()),newUser);
                }
            }
        }
    }

}
