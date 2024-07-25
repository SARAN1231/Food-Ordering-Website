package com.saran.food_server.Repository;

import com.saran.food_server.Models.IngredientsItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientItemsRepository extends JpaRepository<IngredientsItems, Long> {
    List<IngredientsItems> findByRestaurantId(Long restaurantId);
}
