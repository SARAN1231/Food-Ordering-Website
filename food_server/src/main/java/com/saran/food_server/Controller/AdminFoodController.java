package com.saran.food_server.Controller;

import com.saran.food_server.Models.Food;
import com.saran.food_server.Models.Restaurant;
import com.saran.food_server.Models.Users;
import com.saran.food_server.Requests.CreateFoodRequest;
import com.saran.food_server.Responses.MessageResponse;
import com.saran.food_server.Service.FoodService;
import com.saran.food_server.Service.RestaurantService;
import com.saran.food_server.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/food")
public class AdminFoodController {

    private final FoodService foodService;
    private final UserService userService;
    private final RestaurantService restaurantService;

    public AdminFoodController(FoodService foodService, UserService userService, RestaurantService restaurantService) {
        this.foodService = foodService;
        this.userService = userService;
        this.restaurantService = restaurantService;
    }

    @PostMapping("/create")
    public ResponseEntity<Food> addFood(@RequestBody CreateFoodRequest req,
                                        @RequestHeader("Authorization") String jwt) throws Exception {
        Users user = userService.findByJwt(jwt);
        Restaurant restaurant = restaurantService.findRestaurantById(req.getRestaurantId());
        Food food = foodService.createFood(req,restaurant,req.getCategory());
        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{restaurantId}")
    public ResponseEntity<MessageResponse> deletefood(@PathVariable Long restaurantId, @RequestHeader("Authorization") String jwt) throws Exception {
        foodService.deleteFood(restaurantId);
        MessageResponse message = new MessageResponse();
        message.setMessage("Successfully deleted food");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }



    @PutMapping ("{restaurantId}")
    public ResponseEntity<Food> updateFoodAvailability(@PathVariable Long restaurantId, @RequestHeader("Authorization") String jwt) throws Exception {
        Users user = userService.findByJwt(jwt);
        Food food = foodService.updateFoodAvailability(restaurantId);
        return new ResponseEntity<>(food, HttpStatus.OK);
    }
}
