package com.saran.food_server.Repository;

import com.saran.food_server.Models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findByRestaurantId(long id);

    @Query(value = "select f from Food f where lower(f.name) like lower(concat('%',:keyword,'%') ) or lower( f.foodcategory.name) like lower(concat('%',:keyword,'%' ) ) ")
    List<Food> findBySearchQuery(@Param("keyword") String keyword);
}
