package com.saran.food_server.Service;

import com.saran.food_server.Models.Cart;
import com.saran.food_server.Models.CartItems;
import com.saran.food_server.Models.Food;
import com.saran.food_server.Models.Users;
import com.saran.food_server.Repository.CartItemReposistory;
import com.saran.food_server.Repository.CartRepository;
import com.saran.food_server.Requests.CartItemsRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Service
public class CartServiceImp implements CartService{

    private final CartRepository cartRepository;
    private final CartItemReposistory cartItemReposistory;
    private final FoodService foodService;
    private final UserService userService;

    public CartServiceImp(CartRepository cartRepository, CartItemReposistory cartItemReposistory, FoodService foodService, UserService userService) {
        this.cartRepository = cartRepository;
        this.cartItemReposistory = cartItemReposistory;
        this.foodService = foodService;
        this.userService = userService;
    }

    public CartItems addCartItem(CartItemsRequest cartItem,String jwt) throws Exception {
        Users user = userService.findByJwt(jwt);
        Food food = foodService.findFoodById(cartItem.getFoodId());
        Cart cart = cartRepository.findCartByCustomerId(user.getId());
        for(CartItems cartItems : cart.getCartItems()){
            if(cartItems.getFoods().equals(food)){
                int newquantity = cartItems.getQuantity() + cartItem.getQuantity();
                return updateCartItem(cartItem.getFoodId(), newquantity);
            }
        }
        CartItems cartItems = new CartItems();
        cartItems.setFoods(food);
        cartItems.setCart(cart);
        cartItems.setQuantity(cartItem.getQuantity());
        cartItems.setIngredients(cartItems.getIngredients());
        cartItems.setTotalPrice(cartItems.getQuantity()*food.getPrice());
        CartItems  saved = cartItemReposistory.save(cartItems);
        cart.getCartItems().add(saved);
        return saved;
    }

    public Cart getCartByUserId(String jwt) throws Exception {
        Users user = userService.findByJwt(jwt);
        return cartRepository.findCartByCustomerId(user.getId());
    }

    @Override
    public Cart clearCart(String jwt) throws Exception {
        Users user = userService.findByJwt(jwt);
        Cart cart = cartRepository.findCartByCustomerId(user.getId());
        cart.getCartItems().clear();
        return cartRepository.save(cart);
    }

    public CartItems getcartItemById(Long id) throws Exception {

        Optional<CartItems> cartItems =cartItemReposistory.findById(id);
        return cartItems.get();
    }

    public Long CalculatetotalCart(Cart cart) {
        long total = 0L;
        for(CartItems cartItem : cart.getCartItems()) {
            total += cartItem.getQuantity() * cartItem.getFoods().getPrice();
        }
        return total;
    }
    public CartItems updateCartItem(Long id, int  quantity) throws Exception {
        Optional<CartItems> cartItems = cartItemReposistory.findById(id);
        if(cartItems.isEmpty()) {
           throw new Exception("CartItem not found");
        }
        CartItems cartItem = cartItems.get();
        cartItem.setQuantity(quantity);
        cartItem.setTotalPrice(cartItem.getFoods().getPrice() * quantity);
        return cartItemReposistory.save(cartItem);
    }

    public Cart deleteCartItem(Long id,String jwt) throws Exception {
        Users user = userService.findByJwt(jwt);
        Cart cart = cartRepository.findCartByCustomerId(user.getId());
        Optional<CartItems> cartItems = cartItemReposistory.findById(id);
        if(cartItems.isEmpty()) {
            throw new Exception("CartItem not found");
        }
        CartItems cartItem = cartItems.get();
        cart.getCartItems().remove(cartItem);
        return cartRepository.save(cart);
    }

}
