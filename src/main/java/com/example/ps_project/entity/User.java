package com.example.ps_project.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public abstract class User {

    @Id //variabila id este un primary key
    //genereaza primary key-ul automat
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    private String address;

    @OneToMany(targetEntity = OrderList.class, cascade = CascadeType.ALL, mappedBy = "user")
    private List<OrderList> orderLists;

    public User(String firstName, String lastName, String email, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }

    public User(Long id, String first_name, String last_name, String email) {
        this.id = id;
        this.firstName = first_name;
        this.lastName = last_name;
        this.email = email;
        orderLists = new ArrayList<>();
    }

    public User(String first_name, String last_name, String email) {
        this.firstName = first_name;
        this.lastName = last_name;
        this.email = email;
        orderLists = new ArrayList<>();
    }

    public User() {
        orderLists = new ArrayList<>();
    }

    public User(Long id, String firstName, String lastName, String email, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        orderLists = new ArrayList<>();
    }

    public User(Long id, String firstName, String lastName, String email, String address, List<OrderList> orderLists) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.orderLists = orderLists;
    }


}
