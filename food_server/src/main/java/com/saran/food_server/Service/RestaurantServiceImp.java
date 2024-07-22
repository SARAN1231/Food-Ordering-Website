package com.saran.food_server.Service;

import com.saran.food_server.Dtos.Restaurantdto;
import com.saran.food_server.Models.Address;
import com.saran.food_server.Models.Restaurant;
import com.saran.food_server.Models.Users;
import com.saran.food_server.Repository.AdressRepository;
import com.saran.food_server.Repository.RestaurantRepository;
import com.saran.food_server.Repository.UserRepository;
import com.saran.food_server.Requests.CreateRestaurantRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImp implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final AdressRepository adressRepository;
    private final UserRepository userRepository;
    public RestaurantServiceImp(RestaurantRepository restaurantRepository, AdressRepository adressRepository, UserRepository userRepository) {
        this.restaurantRepository = restaurantRepository;
        this.adressRepository = adressRepository;
        this.userRepository = userRepository;
    }
    @Override
    public Restaurant createRestaurant(CreateRestaurantRequest req, Users user) {

        Address address = adressRepository.save(req.getAddress());

        Restaurant restaurant = new Restaurant();

        restaurant.setName(req.getName());
        restaurant.setDescription(req.getDescription());
        restaurant.setAddress(req.getAddress());
        restaurant.setImages(req.getImages());
        restaurant.setContactInformation(req.getContactInformation());
        restaurant.setRegistrationDate(LocalDateTime.now());
        restaurant.setCuisineType(req.getCuisineTpe());
        restaurant.setOpeningHours(req.getOpeningHours());
        restaurant.setCuisineType(req.getCuisineTpe());
        restaurant.setOwner(user);

        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Long RestaurantId, CreateRestaurantRequest updateRequest,Users user) throws Exception {
        Address address = adressRepository.save(updateRequest.getAddress());
        Restaurant restaurant = findRestaurantById(RestaurantId);

        restaurant.setName(updateRequest.getName());
        restaurant.setDescription(updateRequest.getDescription());
        restaurant.setAddress(updateRequest.getAddress());
        restaurant.setImages(updateRequest.getImages());
        restaurant.setContactInformation(updateRequest.getContactInformation());
        restaurant.setRegistrationDate(LocalDateTime.now());
        restaurant.setName(updateRequest.getName());
        restaurant.setOpeningHours(updateRequest.getOpeningHours());

        return restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(Long RestaurantId) throws Exception {
        Restaurant restaurant = findRestaurantById(RestaurantId);
        restaurantRepository.delete(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> searchRestaurants(String search) {
        return restaurantRepository.findBySearchQuery(search);
    }

    @Override
    public Restaurant findRestaurantById(Long RestaurantId) throws Exception {
        Optional<Restaurant> restaurant = restaurantRepository.findById(RestaurantId);
        if(restaurant.isEmpty()) {
            throw new Exception("Restaurant not found with id " + RestaurantId);
        }
        return restaurant.get();
    }

    @Override
    public Restaurant findRestaurantByUserId(Long userId) throws Exception {
        Restaurant restaurant = restaurantRepository.findByOwnerId(userId);
        if(restaurant == null) {
            throw new Exception("Restaurant not found with id " + userId);
        }

        return restaurant;
    }

    @Override
    public Restaurantdto addTOFavourites(Long RestaurantId, Users user) throws Exception {
        Restaurant restaurant = findRestaurantById(RestaurantId);

        Restaurantdto restaurantdto = new Restaurantdto();
        restaurantdto.setId(restaurant.getId());
        restaurantdto.setDescription(restaurant.getDescription());
        restaurantdto.setImage(restaurant.getImages());
        restaurantdto.setTitle(restaurant.getName());

        if(user.getFavourites().contains(restaurantdto)) {
            user.getFavourites().remove(restaurantdto);
        }
        else {
            user.getFavourites().add(restaurantdto);
        }
        userRepository.save(user);
        return restaurantdto;
    }

    @Override
    public Restaurant updateRestaurantStatus(Long RestaurantId) throws Exception {
        Restaurant restaurant = findRestaurantById(RestaurantId);
        restaurant.setOpen(!restaurant.isOpen());
        return restaurantRepository.save(restaurant);
    }
}
