package com.saran.food_server.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String streetAddress;
    private String city;
    private String stateProvince;
    private String postalCode;
    private String country;

}
