package com.saran.food_server.Controller;

import com.saran.food_server.Models.Food;
import com.saran.food_server.Models.Restaurant;
import com.saran.food_server.Models.Users;
import com.saran.food_server.Service.FoodService;
import com.saran.food_server.Service.RestaurantService;
import com.saran.food_server.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class FoodController {


    private final FoodService foodService;
    private final UserService userService;
    private final RestaurantService restaurantService;



    public FoodController(FoodService foodService, UserService userService, RestaurantService restaurantService) {
        this.foodService = foodService;
        this.userService = userService;
        this.restaurantService = restaurantService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Food>> searchFood(@RequestParam String keyword, @RequestHeader("Authorization") String jwt) throws Exception {
        Users user = userService.findByJwt(jwt);
        List<Food> foodList = foodService.searchFood(keyword);
        return new ResponseEntity<>(foodList, HttpStatus.OK);
    }

    @GetMapping("restaurant/{restaurantId}")
    public ResponseEntity<List<Food>> getFood(@PathVariable Long restaurantId, @RequestHeader("Authorization") String jwt ,
                                        @RequestParam(required = false) String category,
                                        @RequestParam boolean vegtarian,
                                        @RequestParam boolean nonveg,
                                        @RequestParam boolean seasonal) throws Exception {
        Users user = userService.findByJwt(jwt);

        List<Food> food = foodService.getFoodByRestaurant(restaurantId,category,vegtarian,nonveg,seasonal);
        return new ResponseEntity<>(food, HttpStatus.OK);
    }
}
