package com.cognizant.service;

import com.cognizant.models.Users;
import com.cognizant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.cognizant.repository.*;
import com.cognizant.models.*;
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService; // directly inject — no WebClient needed!

    public Order createOrder(Long userId, Order order) {
        Users user = userService.getUserById(userId); // validates user exists
        order.setUser(user);
        order.setStatus("PLACED");
        return orderRepository.save(order);
    }

    public List<Order> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Order not found: " + id));
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}