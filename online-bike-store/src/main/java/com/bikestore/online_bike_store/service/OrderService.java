package com.bikestore.online_bike_store.service;

import com.bikestore.online_bike_store.model.CustomerOrder;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<CustomerOrder> findAllOrders();
    Optional<CustomerOrder> findOrderById(Long id);
    void saveOrder(CustomerOrder order);
    void deleteOrderById(Long id);
}
