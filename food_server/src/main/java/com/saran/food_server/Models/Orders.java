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
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
//    @JoinColumn(name = "user_id")
    private Users customer;

    @ManyToOne // many orders can have in one restaurant
    private Restaurant restaurant;

    private Long totalAmount;

    private String orderStatus;

    private Date createdAt;

    @ManyToOne // many orders have single address only
    private Address deliveryAddress;

    @OneToMany // one order can have many order items
    private List<OrderItem> items;

    private int totalItems;

    private int totalPrice;

}
