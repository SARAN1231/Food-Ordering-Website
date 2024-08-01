package com.saran.food_server.Service;

import com.saran.food_server.Models.Orders;
import com.saran.food_server.Models.Users;
import com.saran.food_server.Requests.OrdersRequest;

import java.util.List;

public interface OrderService {

    public Orders createOrder(OrdersRequest order, Users users) throws Exception;

    public Orders updateOrder(Long orderId, String OrderStatus);

    public void cancelOrder(Long orderId);

    public List<Orders> getUsersOrder(Long orderId);

    public List<Orders> getRestauramtOrders(Long orderId, String OrderStatus);
}
