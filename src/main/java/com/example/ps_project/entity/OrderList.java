package com.example.ps_project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name="shopping_list")
@Entity
public class OrderList {
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

    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL, mappedBy = "orderList")
    private List<Product> products;

    private Float total_price;

    private boolean delivered;

    public OrderList() {
        products = new ArrayList<>();
    }

    public OrderList(Long id, User user, Float price) {
        this.id = id;
        this.user = user;
        products = new ArrayList<>();
    }


    public OrderList(Long id, User user, Float price, int delivered) {
        this.id = id;
        this.user = user;
        this.products = new ArrayList<>();
    }
}
