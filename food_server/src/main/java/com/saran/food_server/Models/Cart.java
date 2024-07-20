package com.saran.food_server.Models;

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
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Users customer;

    private Long total;

    @OneToMany(mappedBy = "cart" , cascade = CascadeType.ALL, orphanRemoval = true)
    List<CartItems> cartItems = new ArrayList<>();
}
