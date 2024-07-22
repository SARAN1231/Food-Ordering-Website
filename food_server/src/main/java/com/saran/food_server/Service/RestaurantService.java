package com.saran.food_server.Service;

import com.saran.food_server.Dtos.Restaurantdto;
import com.saran.food_server.Models.Restaurant;
import com.saran.food_server.Models.Users;
import com.saran.food_server.Requests.CreateRestaurantRequest;

import java.util.List;

public interface RestaurantService {

  public Restaurant createRestaurant(CreateRestaurantRequest req, Users user);

  public Restaurant updateRestaurant(Long RestaurantId,CreateRestaurantRequest updateRequest,Users user ) throws  Exception;

  public void deleteRestaurant(Long RestaurantId) throws Exception;


  public List<Restaurant> getAllRestaurants();

  public List<Restaurant> searchRestaurants(String search);

  public Restaurant findRestaurantById(Long RestaurantId) throws Exception;

  public Restaurant findRestaurantByUserId(Long userId) throws Exception;

  public Restaurantdto addTOFavourites(Long RestaurantId, Users user) throws Exception;

  public Restaurant updateRestaurantStatus(Long RestaurantId) throws Exception;



}
