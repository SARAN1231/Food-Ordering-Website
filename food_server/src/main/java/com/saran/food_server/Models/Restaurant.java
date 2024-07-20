package com.saran.food_server.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Users owner;

    private String name;
    private String description;

    @OneToOne
    private Address address;

    @Embedded
    private ContactInformation contactInformation; // When you use the @Embedded annotation, JPA treats the fields of the ContactInformation class as if they were fields of the Restaurant entity itself. The columns for these fields will be created in the Restaurant table.

    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orders> orders;

    @ElementCollection
    @Column(length = 1000)
    private List<String> images;

    private LocalDateTime registrationDate;
    private boolean open;

    @JsonIgnore // mappedby tella that list of foods should be store in same table if not it creates a new table
    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Food> foods;
}
