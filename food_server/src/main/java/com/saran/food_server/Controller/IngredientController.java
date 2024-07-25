package com.saran.food_server.Controller;

import com.saran.food_server.Models.Category;
import com.saran.food_server.Models.IngredientCategory;
import com.saran.food_server.Models.IngredientsItems;
import com.saran.food_server.Requests.IngredientCategoryRequest;
import com.saran.food_server.Requests.IngredientRequest;
import com.saran.food_server.Service.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping("/category")
    public ResponseEntity<IngredientCategory> addCategory(@RequestBody IngredientCategoryRequest ingredientCategoryRequest) throws Exception {
        IngredientCategory ingredientCategory = ingredientService.createingredientCategory(ingredientCategoryRequest.getName(), ingredientCategoryRequest.getRestaurantId());
        return new ResponseEntity<>(ingredientCategory, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<IngredientsItems> addIngredients(@RequestBody IngredientRequest req) throws Exception {
        IngredientsItems ingredientsItems = ingredientService.createIngredientsItems(req.getName(), req.getRestaurantId(), req.getCategoryId());
        return new ResponseEntity<>(ingredientsItems, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/stock")

    public ResponseEntity<IngredientsItems> UpdateStock(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(ingredientService.updateStock(id), HttpStatus.OK);
    }

    @GetMapping("/restaurant/{id} ")
    public ResponseEntity< List<IngredientsItems> > getIngredients(@PathVariable Long restaurantId) throws Exception {
        List<IngredientsItems> ingredientsItemsList = ingredientService.getAllIngredientsItems(restaurantId);
        return new ResponseEntity<>(ingredientsItemsList,HttpStatus.OK);
    }

    @GetMapping("/restaurant/{id}/category ")
    public ResponseEntity<List<IngredientCategory>> getCategory(@PathVariable Long resid) throws Exception {
        List<IngredientCategory> ingredientCategories = ingredientService.getAllIngredientCategories(resid);
        return new ResponseEntity<>(ingredientCategories,HttpStatus.OK);
    }


}
