package com.bikestore.online_bike_store.controller;

import com.bikestore.online_bike_store.model.CustomerOrder;
import com.bikestore.online_bike_store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    // Constructor-based dependency injection for the OrderService.
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Endpoint to retrieve all orders.
    @GetMapping
    public List<CustomerOrder> getAllOrders() {
        return orderService.findAllOrders();
    }

    // Endpoint to retrieve an order by ID.
    @GetMapping("/{id}")
    public Optional<CustomerOrder> getOrderById(@PathVariable Long id) {
        return orderService.findOrderById(id);
    }

    // Endpoint to create or update an order.
    @PostMapping
    public void saveOrder(@RequestBody CustomerOrder order) {
        orderService.saveOrder(order);
    }

    // Endpoint to delete an order by ID.
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrderById(id);
    }
}
