package com.example.ps_project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="order")
public class Order {
    @Id//variabila id este un primary key
    //genereaza primary key-ul automat
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_sequence"
    )
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Float price;

    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL, mappedBy = "order")
    private List<Product> products;

    private boolean delivered;

    public Order() {
        products = new ArrayList<>();
    }

    public Order(Long id, User user, Float price) {
        this.id = id;
        this.user = user;
        this.price = price;
        products = new ArrayList<>();
    }

    public Order(Long id, User user, Float price, List<Product> products) {
        this.id = id;
        this.user = user;
        this.price = price;
        this.products = products;
    }

    public Order(Long id, User user, Float price, boolean delivered) {
        this.id = id;
        this.user = user;
        this.price = price;
        this.products = new ArrayList<>();
        this.delivered = delivered;
    }
}
