package com.saran.food_server.Service;

import com.saran.food_server.Models.Category;
import com.saran.food_server.Models.Food;
import com.saran.food_server.Models.Restaurant;
import com.saran.food_server.Repository.FoodRepository;
import com.saran.food_server.Repository.RestaurantRepository;
import com.saran.food_server.Requests.CreateFoodRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodServiceImp implements FoodService{
    private final FoodRepository foodRepository;

    public FoodServiceImp(FoodRepository foodRepository, RestaurantRepository restaurantRepository ) {
        this.foodRepository = foodRepository;

    }

    @Override
    public Food createFood(CreateFoodRequest req, Restaurant restaurant, Category category) {
        Food food = new Food();
        food.setRestaurant(restaurant);
        food.setName(req.getName());
        food.setDescription(req.getDescription());
        food.setPrice(req.getPrice());
        food.setFoodcategory(category);
        food.setImages(req.getImages());
        food.setIngredientsItems(req.getIngredients());
        food.setSeasonal(req.isSeasonal());
        food.setVegetarian(req.isVegetarian());
        Food savedfood = foodRepository.save(food);
        restaurant.getFoods().add(savedfood); // add to already existing food
        return food;
    }

    @Override
    public void deleteFood(Long foodId) throws Exception {
        Optional<Food> food  = foodRepository.findById(foodId);
        if(food.isPresent()) {
            food.get().setRestaurant(null);
            foodRepository.save(food.get()); // removing the restaurant from food bocz when user gets Abc Restaurant it gives all food related to restaurant. In this it is not given
        }
    }

    @Override
    public List<Food> getFoodByRestaurant(Long restaurantId, String category, boolean isVegtarian, boolean isNonveg, boolean isSeasonal) {
        List<Food> foods = foodRepository.findByRestaurantId(restaurantId);
        if(isVegtarian) {
            foods  = filerByVeg(foods,isVegtarian);
        }
        if(isNonveg) {
            foods = filterByNonVeg(foods,isNonveg);
        }
        if(isSeasonal) {
            foods = filterBySeasonal(foods,isSeasonal);
        }
        if(category != null ) {
            foods = flterByCategory(foods,category);
        }
        return foods;
    }

    private List<Food> flterByCategory(List<Food> foods, String category) {
        return foods.stream().filter(food -> {
            if(food.getFoodcategory() != null) {
                return food.getFoodcategory().getName().equals(category);
            }
            return false;
        }).collect(Collectors.toList());
    }

    private List<Food> filterBySeasonal(List<Food> foods, boolean isSeasonal) {
        return foods.stream().filter(food -> food.isSeasonal() == isSeasonal).collect(Collectors.toList());
    }

    private List<Food> filterByNonVeg(List<Food> foods, boolean isNonveg) {
        return foods.stream().filter(food -> food.isVegetarian() == false).collect(Collectors.toList());
    }

    private List<Food> filerByVeg(List<Food> foods, boolean isVegtarian) {
        return foods.stream().filter(food -> food.isVegetarian() == isVegtarian).collect(Collectors.toList());
    }

    @Override
    public Food findFoodById(Long id) throws Exception {
        Optional<Food> food = foodRepository.findById(id);
       if(food.isPresent()) {
           return food.get();
       }
       else {
           throw new Exception("Food not found.....");
       }
    }

    @Override
    public List<Food> searchFood(String keyword) {
        return foodRepository.findBySearchQuery( keyword);
    }

    @Override
    public Food updateFoodAvailability(Long foodId) throws Exception {
        Food food = findFoodById(foodId);

            food.setAvailable(!food.isAvailable());
            foodRepository.save(food);

        return food;
    }
}
