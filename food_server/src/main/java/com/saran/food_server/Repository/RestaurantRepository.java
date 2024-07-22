package com.saran.food_server.Repository;

import com.saran.food_server.Models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Restaurant findByOwnerId(Long userid);

    // for searching restaurant
    @Query("select  r from Restaurant r where lower(r.name) like lower(concat('%',:query,'%') ) OR  lower(r.cuisineType) like lower(concat('%',:query,'%' ))")
    List<Restaurant> findBySearchQuery(String query);
}
