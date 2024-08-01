package com.saran.food_server.Requests;

import com.saran.food_server.Models.Address;
import lombok.Data;

@Data
public class OrdersRequest {
    private Long RestaurantId;
    private Address deliveryAddress;
}
