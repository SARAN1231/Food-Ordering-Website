package com.saran.food_server.Repository;

import com.saran.food_server.Models.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemReposistory extends JpaRepository<CartItems,Long> {

}
