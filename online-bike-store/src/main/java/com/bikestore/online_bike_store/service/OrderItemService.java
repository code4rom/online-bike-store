package com.bikestore.online_bike_store.service;

import com.bikestore.online_bike_store.model.OrderItem;
import java.util.List;
import java.util.Optional;

public interface OrderItemService {
    List<OrderItem> findAllOrderItems();
    Optional<OrderItem> findOrderItemById(Long id);
    void saveOrderItem(OrderItem orderItem);
    void deleteOrderItemById(Long id);
}
