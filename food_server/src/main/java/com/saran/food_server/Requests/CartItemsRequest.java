package com.saran.food_server.Requests;

import lombok.Data;

import java.util.List;

@Data
public class CartItemsRequest {

    private Long foodId;
    private int quantity;
    private List<String> Ingredients;

}
