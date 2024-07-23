package com.saran.food_server.Service;

import com.saran.food_server.Models.Category;
import com.saran.food_server.Models.Food;
import com.saran.food_server.Models.Restaurant;
import com.saran.food_server.Requests.CreateFoodRequest;

import java.util.List;

public interface FoodService {

    public Food createFood(CreateFoodRequest req , Restaurant restaurant, Category category);

    public  void deleteFood (Long foodId) throws Exception;

    public List<Food> getFoodByRestaurant(Long restaurantId, String category,boolean isVegtarian, boolean isNonveg,boolean isSeasonal);

    public Food findFoodById(Long id) throws Exception;

    public List<Food> searchFood(String Keyword);

    public Food updateFoodAvailability(Long foodId) throws Exception;
}
