package com.bikestore.online_bike_store.repository;

import com.bikestore.online_bike_store.model.CustomerOrder;
import com.bikestore.online_bike_store.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
