package com.bikestore.online_bike_store.service;

import com.bikestore.online_bike_store.model.Order;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> findAllOrders();
    Optional<Order> findOrderById(Long id);
    void saveOrder(Order order);
    void deleteOrderById(Long id);
}
