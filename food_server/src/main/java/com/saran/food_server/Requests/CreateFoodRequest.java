package com.saran.food_server.Requests;


import com.saran.food_server.Models.Category;
import com.saran.food_server.Models.IngredientsItems;
import lombok.Data;

import java.util.List;

@Data
public class CreateFoodRequest {

    private String name;
    private String description;
    private Long price;
    private Category category;
    private List<String> images;
    private boolean vegetarian;
    private boolean seasonal;
    private List<IngredientsItems> ingredients;
    private Long restaurantId;
}
