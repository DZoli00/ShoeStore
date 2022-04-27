package com.example.ps_project.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="product")
public class Product {

    @Id//variabila id este un primary key
    //genereaza primary key-ul automat
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_seqence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_seqence"
    )
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Float price;

    //aici am creat un foreign key cu primary key-ul din tabelul category
    //relatia @ManyToOne pentru ca un produs poate sa apartina doar intr-o categorie
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private Float rating;
    private String description;
    private String color;
    private String brand;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Product( String name, Float price, Category category, Float rating, String description, String color, String brand) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.description = description;
        this.color = color;
        this.brand = brand;
        this.category = category;
        category.getProductList().add(this);
    }

    public Product(String name, Float price, Float rating, String description, String color, String brand) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.description = description;
        this.color = color;
        this.brand = brand;
    }
    public Product() {

    }

}
