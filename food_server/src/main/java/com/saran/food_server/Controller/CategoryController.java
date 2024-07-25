package com.saran.food_server.Controller;

import com.saran.food_server.Models.Category;
import com.saran.food_server.Models.Users;
import com.saran.food_server.Service.CategoryService;
import com.saran.food_server.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class CategoryController {

    private final CategoryService categoryService;
    private final UserService userService;
    public CategoryController(CategoryService categoryService, UserService userService) {
        this.categoryService = categoryService;
        this.userService = userService;
    }
     @PostMapping("admin/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category , @RequestHeader("Authorization") String jwt) throws Exception {
         Users user = userService.findByJwt(jwt);
         Category category1 = categoryService.createCategory(category.getName(), user.getId());
         return new ResponseEntity<>(category1, HttpStatus.CREATED);

     }

     @GetMapping("category/restaurant")
    public ResponseEntity<List<Category>> getCategoryRestaurants(@RequestHeader("Authorization") String jwt) throws Exception {
        Users user = userService.findByJwt(jwt);
        List<Category> categories = categoryService.getCategoriesByRestaurantId(user.getId());
        return new ResponseEntity<>(categories, HttpStatus.OK);
     }

     @GetMapping("category/restaurant/{id}")
    public ResponseEntity<Category> getCategoryById(@RequestHeader("Authorization") String jwt, @PathVariable Long id) throws Exception {
        Users user = userService.findByJwt(jwt);
       Category category= categoryService.findCategoryBtId(id);
       return new ResponseEntity<>(category, HttpStatus.OK);
     }
}
