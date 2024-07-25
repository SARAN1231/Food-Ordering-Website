package com.saran.food_server.Requests;

import lombok.Data;

@Data
public class IngredientRequest {
    private String Name;
    private Long CategoryId;
    private Long RestaurantId;
}
