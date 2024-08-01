package com.saran.food_server.Repository;

import com.saran.food_server.Models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository  extends JpaRepository<Cart,Long> {
    Cart findCartByCustomerId(Long customerId);
}
