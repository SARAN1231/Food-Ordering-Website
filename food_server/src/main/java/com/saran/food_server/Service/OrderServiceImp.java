package com.saran.food_server.Service;

import com.saran.food_server.Models.*;
import com.saran.food_server.Repository.AdressRepository;
import com.saran.food_server.Repository.OrderRepository;
import com.saran.food_server.Repository.RestaurantRepository;
import com.saran.food_server.Repository.UserRepository;
import com.saran.food_server.Requests.OrdersRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService{

    private final OrderRepository orderRepository;
    private final UserService userService;
    private final OrderItem orderItem;
    private final AdressRepository adressRepository;
    private final RestaurantService restaurantService;
    private final UserRepository userRepository;
    public OrderServiceImp(OrderRepository orderRepository, UserService userService, OrderItem orderItem, AdressRepository adressRepository, RestaurantRepository restaurantRepository, RestaurantService restaurantService, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.orderItem = orderItem;
        this.adressRepository = adressRepository;
        this.restaurantService = restaurantService;

        this.userRepository = userRepository;
    }

    @Override
    public Orders createOrder(OrdersRequest order, Users users) throws Exception {

        Address shippingAddress = order.getDeliveryAddress();
        Address deliveryAddress = adressRepository.save(shippingAddress);
        if(!users.getAddresses().contains(deliveryAddress)) {
            users.getAddresses().add(deliveryAddress);
            userRepository.save(users);
        }

        Restaurant restaurant = restaurantService.findRestaurantById(order.getRestaurantId());

        Orders orders = new Orders();
        return null;
    }

    @Override
    public Orders updateOrder(Long orderId, String OrderStatus) {
        return null;
    }

    @Override
    public void cancelOrder(Long orderId) {

    }

    @Override
    public List<Orders> getUsersOrder(Long orderId) {
        return List.of();
    }

    @Override
    public List<Orders> getRestauramtOrders(Long orderId, String OrderStatus) {
        return List.of();
    }
}
