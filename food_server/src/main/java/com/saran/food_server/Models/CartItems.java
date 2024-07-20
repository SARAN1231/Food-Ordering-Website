package com.saran.food_server.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    private Cart cart;

    @ManyToOne // one cart item has many foods(same) ex -> if i order biryani and my friend also order biryani then cart items ha same food
    private Food foods;

    private int quantity;

    private List<String> Ingredients;

    private Long totalPrice;

}
