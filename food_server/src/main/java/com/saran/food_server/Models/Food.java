package com.saran.food_server.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Long price;

    @ManyToOne
    private Category foodcategory;

    @Column(length = 1000)
    @ElementCollection // this will create a seperate table for food images with food id
    private List<String> images;

    private boolean available;

    @ManyToOne
    private Restaurant restaurant;

    private boolean isVegetarian;

    private boolean isSeasonal;

    @ManyToMany // many food has same ingredients ex -> burger(bread sauce onion chicken ) these all can be part of another food so many to many
    private List<IngredientsItems> IngredientsItems = new ArrayList<>();

    private Date creationDate;
}
