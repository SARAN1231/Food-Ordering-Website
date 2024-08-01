package com.saran.food_server.Controller;

import com.saran.food_server.Models.Cart;
import com.saran.food_server.Models.CartItems;
import com.saran.food_server.Requests.CartItemsRequest;
import com.saran.food_server.Requests.UpdateCartItemRequest;
import com.saran.food_server.Service.CartService;
import com.saran.food_server.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class CartController {
    private final CartService cartService;
    private final UserService userService;

    public CartController(CartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }

    @PostMapping("/cart/add")
    public ResponseEntity<CartItems> addCart(@RequestBody CartItemsRequest  req, @RequestHeader("Authorization") String jwt) throws Exception {
        CartItems cartItems = cartService.addCartItem(req,jwt);
        return new ResponseEntity<>(cartItems, HttpStatus.CREATED);
    }

    @PutMapping("/cart-item/update/{id}")
    public ResponseEntity<CartItems> updateCart(@RequestBody UpdateCartItemRequest req) throws Exception {
        CartItems cartItems = cartService.updateCartItem(req.getCartItemId(),req.getQuantity());
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }

    @DeleteMapping("/cart-item/delete/{id}")
    public ResponseEntity<Cart> deleteCart(@PathVariable Long id,String jwt) throws Exception {
        Cart cart = cartService.deleteCartItem(id,jwt);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @GetMapping("cart")
    public ResponseEntity<Cart> getCart(@RequestHeader("Authorization") String jwt) throws Exception {
        Cart cart = cartService.getCartByUserId(jwt);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PutMapping("cart/clear")
    public ResponseEntity<Cart> clearCart(@RequestHeader("Authorization") String jwt) throws Exception {
        Cart cart = cartService.clearCart(jwt);
    }
}
