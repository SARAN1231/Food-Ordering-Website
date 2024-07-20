package com.saran.food_server.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "deliveryAddress")
//    private List<Orders> orders;
}
