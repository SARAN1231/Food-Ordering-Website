package com.saran.food_server.Controller;

import com.saran.food_server.Models.Restaurant;
import com.saran.food_server.Models.Users;
import com.saran.food_server.Requests.CreateRestaurantRequest;
import com.saran.food_server.Responses.MessageResponse;
import com.saran.food_server.Service.RestaurantService;
import com.saran.food_server.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/restaurants")
public class AdminRestaurantController {

    private final RestaurantService restaurantService;
    private final UserService userService;

    public AdminRestaurantController(RestaurantService restaurantService, UserService userService) {
        this.restaurantService = restaurantService;
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody CreateRestaurantRequest req, @RequestHeader("Authorization") String jwt) throws Exception {
        Users user = userService.findByJwt(jwt);
        Restaurant restaurant = restaurantService.createRestaurant(req, user);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    @PutMapping("/update/{restaurantId}")
    public ResponseEntity<Restaurant> updateRestaurant(@RequestBody CreateRestaurantRequest req,
                                                       @RequestHeader("Authorization") String jwt,
                                                       @PathVariable Long restaurantId) throws Exception {

        Users user = userService.findByJwt(jwt);
        Restaurant restaurant = restaurantService.updateRestaurant(restaurantId, req, user);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{restaurantId}")
    public ResponseEntity<MessageResponse> deleteRestaurant(@PathVariable Long restaurantId ,
                                                            @RequestHeader("Authorization") String jwt) throws Exception {
        restaurantService.deleteRestaurant(restaurantId);
        MessageResponse res = new MessageResponse();
        res.setMessage("Restaurant deleted successfully");
        return new ResponseEntity<>(res,HttpStatus.OK);

    }

    @PutMapping("{restaurantId}/status")
    public ResponseEntity<Restaurant> updateRestaurantStatus(
                                                             @RequestHeader("Authorization") String jwt,
                                                             @PathVariable Long restaurantId) throws Exception {
    Restaurant restaurant = restaurantService.updateRestaurantStatus(restaurantId);
  return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<Restaurant> findRestaurantByUserId(@RequestHeader("Authorization") String jwt) throws Exception {
        Users user = userService.findByJwt(jwt);

        Restaurant restaurant = restaurantService.findRestaurantByUserId(user.getId());
        return new ResponseEntity<>(restaurant, HttpStatus.OK);

    }
}
