package com.bikestore.online_bike_store.repository;

import com.bikestore.online_bike_store.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
