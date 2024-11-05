package com.bikestore.online_bike_store.controller;

import com.bikestore.online_bike_store.model.OrderItem;
import com.bikestore.online_bike_store.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order-items")
public class OrderItemController {

    private final OrderItemService orderItemService;

    // Constructor-based dependency injection for the OrderItemService.
    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    // Endpoint to retrieve all order items.
    @GetMapping
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.findAllOrderItems();
    }

    // Endpoint to retrieve an order item by ID.
    @GetMapping("/{id}")
    public Optional<OrderItem> getOrderItemById(@PathVariable Long id) {
        return orderItemService.findOrderItemById(id);
    }

    // Endpoint to create or update an order item.
    @PostMapping
    public void saveOrderItem(@RequestBody OrderItem orderItem) {
        orderItemService.saveOrderItem(orderItem);
    }

    // Endpoint to delete an order item by ID.
    @DeleteMapping("/{id}")
    public void deleteOrderItem(@PathVariable Long id) {
        orderItemService.deleteOrderItemById(id);
    }
}
