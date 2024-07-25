package com.saran.food_server.Service;

import com.saran.food_server.Models.Category;
import com.saran.food_server.Models.Restaurant;
import com.saran.food_server.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryService {

    private CategoryRepository categoryRepository;
    private final RestaurantService restaurantService;
    public CategoryServiceImp(CategoryRepository categoryRepository, RestaurantService restaurantService) {
        this.categoryRepository = categoryRepository;
        this.restaurantService = restaurantService;
    }
    @Override
    public Category createCategory(String category, Long userid) throws Exception {
        Restaurant restaurant = restaurantService.findRestaurantByUserId(userid);
        Category category1 = new Category();
        category1.setName(category);
        category1.setRestaurant(restaurant);

        return categoryRepository.save(category1);
    }

    @Override
    public Category findCategoryBtId(Long id) throws Exception {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()) {
            throw new Exception("Category not found");
        }

        return category.get();
    }

    @Override
    public List<Category> getCategoriesByRestaurantId(Long userid) throws Exception {
        Restaurant restaurant = restaurantService.findRestaurantByUserId(userid);
        return categoryRepository.findByRestaurantId(restaurant.getId());
    }
}
