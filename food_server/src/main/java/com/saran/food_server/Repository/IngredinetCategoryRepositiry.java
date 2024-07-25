package com.saran.food_server.Repository;

import com.saran.food_server.Models.IngredientCategory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredinetCategoryRepositiry extends JpaRepository<IngredientCategory, Long> {

    List<IngredientCategory> findByRestaurantId(Long restaurantId);
}
