package com.saran.food_server.Controller;

import com.saran.food_server.Dtos.Restaurantdto;
import com.saran.food_server.Models.Restaurant;
import com.saran.food_server.Models.Users;
import com.saran.food_server.Requests.CreateRestaurantRequest;
import com.saran.food_server.Service.RestaurantService;
import com.saran.food_server.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final UserService userService;


    public RestaurantController(RestaurantService restaurantService, UserService userService) {
        this.restaurantService = restaurantService;
        this.userService = userService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Restaurant>> searchRestaurants(@RequestParam String search,
                                                              @RequestHeader("Authorization") String jwt) throws Exception {
        Users user = userService.findByJwt(jwt);
        List<Restaurant> restaurants = restaurantService.searchRestaurants(search);
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Restaurant>> getAllRestaurants(@RequestHeader("Authorization") String jwt) throws Exception {
        Users user = userService.findByJwt(jwt);
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @GetMapping("{restaurantid}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long restaurantid ,
                                                        @RequestHeader("Authorization") String jwt) throws Exception {
        Users user = userService.findByJwt(jwt);
        Restaurant restaurant = restaurantService.findRestaurantById(restaurantid);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @PostMapping("{restaurantid}/favourites")
    public ResponseEntity<Restaurantdto> addToFavourites(@RequestHeader("Authorization") String jwt ,
                                                         @PathVariable Long restaurantid) throws Exception {
        Users user = userService.findByJwt(jwt);
        Restaurantdto Restaurantdto = restaurantService.addTOFavourites(restaurantid,user);
        return new ResponseEntity<>(Restaurantdto, HttpStatus.OK);

    }
}
