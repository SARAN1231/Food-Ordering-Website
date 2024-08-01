package com.saran.food_server.Service;

import com.saran.food_server.Models.Cart;
import com.saran.food_server.Models.CartItems;
import com.saran.food_server.Requests.CartItemsRequest;

public interface CartService {

    public CartItems addCartItem(CartItemsRequest cartItems, String jwt) throws Exception;

    public CartItems updateCartItem(Long id,  int quantity) throws Exception;

    public Cart deleteCartItem(Long id, String jwt) throws Exception;

    public Long CalculatetotalCart(Cart cart) ;

    public CartItems getcartItemById(Long id) throws Exception;

    public Cart getCartByUserId(String jwt) throws Exception;

    public Cart clearCart(String jwt) throws Exception;
}
