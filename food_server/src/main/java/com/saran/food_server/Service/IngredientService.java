package com.saran.food_server.Service;

import com.saran.food_server.Models.IngredientCategory;
import com.saran.food_server.Models.IngredientsItems;

import java.util.List;

public interface IngredientService {
    public IngredientCategory createingredientCategory(String name , Long restaurantId) throws Exception;

    public List<IngredientCategory> getAllIngredientCategories(Long restaurantId) throws Exception;
    public IngredientCategory getIngredientCategoryById(Long id) throws Exception;

    public IngredientsItems createIngredientsItems(String name , Long restaurantId,Long categoryId) throws Exception;
    public List<IngredientsItems> getAllIngredientsItems(Long restaurantId);
    public IngredientsItems updateStock(Long id) throws Exception;
}
