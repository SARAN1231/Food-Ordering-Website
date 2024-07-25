package com.saran.food_server.Service;

import com.saran.food_server.Models.Category;

import java.util.List;

public interface CategoryService {

    public Category createCategory(String category,Long userid) throws Exception;

    public Category findCategoryBtId(Long id) throws Exception;

    public List<Category> getCategoriesByRestaurantId(Long restaurantId) throws Exception;
}
