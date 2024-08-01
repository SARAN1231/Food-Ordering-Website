package com.saran.food_server.Repository;

import com.saran.food_server.Models.Orders;
import jakarta.persistence.criteria.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    public List<Orders> findByCustomerId(Long customerId);

    public List<Orders> findByRestaurantId(Long restaurantId);
}
