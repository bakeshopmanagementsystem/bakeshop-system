package com.timesbakeshop.system.controller;

import com.timesbakeshop.system.model.Order;
import com.timesbakeshop.system.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderDashboardController {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderDashboardController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    @Secured("ROLE_USER")
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("{orderId}")
    @Secured("ROLE_USER")
    public Order getOrderById(@PathVariable Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    @GetMapping("getOrdersByCakeType")
    @Secured("ROLE_USER")
    public List<Order> getOrdersByCakeType(@RequestParam List<String> types) {
        return new ArrayList<>();
    }

    @GetMapping("getOrdersByStatus")
    @Secured("ROLE_USER")
    public List<Order> getOrdersByStatus(@RequestParam List<String> types) {
        return new ArrayList<>();
    }

    @PostMapping
    @Secured("ROLE_USER")
    public ResponseEntity<String> createOrder(@RequestBody Order payload) {
        Order order = orderRepository.save(payload);
        if (order == null) return ResponseEntity.internalServerError().body("Could not create new order.");
        return ResponseEntity.ok("Successfully created order.");
    }

    @PutMapping("{orderId}")
    @Secured("ROLE_USER")
    public ResponseEntity<String> updateOrderById(@PathVariable Long orderId, @RequestBody Order payload) {
        Order savedOrder = orderRepository.findById(orderId).orElse(null);
        if (savedOrder == null) {
            return ResponseEntity.badRequest().body(String.format("Could not find order no. %s", orderId));
        }
        orderRepository.save(updateOrderDetails(savedOrder, payload));
        return ResponseEntity.ok(String.format("Successfully updated order no. %s", orderId));
    }

    @DeleteMapping("{orderId}")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<String> deleteOrderById(@PathVariable String orderId) {
        return ResponseEntity.ok(String.format("Successfully deleted order no. %s", orderId));
    }

    private Order updateOrderDetails(Order savedOrder, Order payload) {
        savedOrder.setCustomerName(payload.getCustomerName());
        savedOrder.setPickUpDate(payload.getPickUpDate());
        savedOrder.setDescription(payload.getDescription());
        savedOrder.setCakes(payload.getCakes());
        savedOrder.setUpdatedDate(LocalDateTime.now());
        return savedOrder;
    }

}
