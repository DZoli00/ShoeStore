package com.example.ps_project.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@Entity
@Table
public class Category {

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
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    //foreign key cu tabelul product
    //avem relatie de OneToMany, deoarece putem sa avem mai multe produse intr-o categorie
    @OneToMany( targetEntity = Product.class, cascade = CascadeType.ALL, mappedBy = "category")
    private List<Product> productList = new ArrayList<>();

    public Category() {
    }

    public Category(Long category_id, String name, String description, List<Product> productList) {
        this.id = category_id;
        this.name = name;
        this.description = description;
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
