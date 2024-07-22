package com.saran.food_server.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.saran.food_server.Dtos.Restaurantdto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password; //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) is used to mark the password field so it will only be used during deserialization (input) and not during serialization (output).


    private USER_ROLE role = USER_ROLE.ROLE_CUSTOMER;

    @JsonIgnore // ignoring orders while fetching user
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer") // one user can have many orders
    private List<Orders> orders = new ArrayList<>();

    @ElementCollection // @ElementCollection is used to define a collection of instances of a basic type or an embeddable class. It is used when you want to store a collection of values that are not entities themselves but are part of an entity. These collections are typically stored in a separate table.
    private List<Restaurantdto> favourites = new ArrayList<>(); //This indicates that the favourites field is a collection of Restaurantdto instances, and JPA will handle it as an element collection. The favourites field will be stored in a separate table, and the Users table will have a foreign key reference to this table.

    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true) //if user deleted then  automatically deleted from the address table //one user can have many address(bcoz he is in diff location while ordering food)
    private List<Address> addresses = new ArrayList<>();
}
