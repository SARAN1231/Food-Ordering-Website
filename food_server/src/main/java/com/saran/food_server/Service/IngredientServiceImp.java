package com.saran.food_server.Service;

import com.saran.food_server.Models.Category;
import com.saran.food_server.Models.IngredientCategory;
import com.saran.food_server.Models.IngredientsItems;
import com.saran.food_server.Models.Restaurant;
import com.saran.food_server.Repository.IngredientItemsRepository;
import com.saran.food_server.Repository.IngredinetCategoryRepositiry;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceImp implements IngredientService {

    private final RestaurantService restaurantService;
  private final IngredinetCategoryRepositiry ingredinetCategoryRepositiry;
  private final IngredientItemsRepository ingredientItemsRepository;
  private final CategoryService categoryService;

    public IngredientServiceImp(RestaurantService restaurantService, IngredinetCategoryRepositiry ingredinetCategoryRepositiry, IngredientItemsRepository ingredientItemsRepository, CategoryService categoryService) {
        this.restaurantService = restaurantService;
        this.ingredinetCategoryRepositiry = ingredinetCategoryRepositiry;
        this.ingredientItemsRepository = ingredientItemsRepository;
        this.categoryService = categoryService;
    }

    @Override
    public IngredientCategory createingredientCategory(String name, Long restaurantId) throws Exception {
        IngredientCategory ingredientCategory = new IngredientCategory();
        ingredientCategory.setName(name);
        Restaurant restaurant = restaurantService.findRestaurantById(restaurantId);
        ingredientCategory.setRestaurant(restaurant);
        return ingredinetCategoryRepositiry.save(ingredientCategory);

    }

    @Override
    public List<IngredientCategory> getAllIngredientCategories(Long restaurantId) throws Exception {
        restaurantService.findRestaurantById(restaurantId); // check and throw exception by checking restaurant id
        return ingredinetCategoryRepositiry.findByRestaurantId(restaurantId);
    }

    @Override
    public IngredientCategory getIngredientCategoryById(Long resid) throws Exception {
        Optional<IngredientCategory> ingredientCategoryOptional = ingredinetCategoryRepositiry.findById(resid);
        if(ingredientCategoryOptional.isEmpty()){
            throw new Exception("Ingredient Category not found");
        }
        return ingredientCategoryOptional.get();
    }

    @Override
    public IngredientsItems createIngredientsItems(String name, Long restaurantId, Long categoryId) throws Exception {
        IngredientsItems ingredientsItems = new IngredientsItems();
        ingredientsItems.setName(name);
        Restaurant restaurant = restaurantService.findRestaurantById(restaurantId);
        ingredientsItems.setRestaurant(restaurant);
        IngredientCategory ingredientCategory = getIngredientCategoryById(categoryId);
        ingredientsItems.setCategory(ingredientCategory);
        IngredientsItems ingredients = ingredientItemsRepository.save(ingredientsItems);
        ingredientCategory.getIngredientsItems().add(ingredients);
        return ingredients;
    }

    @Override
    public List<IngredientsItems> getAllIngredientsItems(Long restaurantId) {

        return ingredientItemsRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public IngredientsItems updateStock(Long id) throws Exception {
        Optional<IngredientsItems> ingredientsItems = ingredientItemsRepository.findById(id);
        if(ingredientsItems.isEmpty()){
            throw new Exception("Ingredient not found");
        }
        IngredientsItems ingredientsItem = ingredientsItems.get();
        ingredientsItem.setInStock(!ingredientsItem.isInStock());
        return ingredientItemsRepository.save(ingredientsItem);
    }
}
