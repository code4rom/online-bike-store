package com.bikestore.online_bike_store.service;

import com.bikestore.online_bike_store.model.CustomerOrder;
import com.bikestore.online_bike_store.model.User;
import com.bikestore.online_bike_store.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<CustomerOrder> findOrdersByUser(User user) {
        return orderRepository.findByUser(user);
    }
    @Override
    public List<CustomerOrder> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<CustomerOrder> findOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public void saveOrder(CustomerOrder order) {
        orderRepository.save(order);
    }

    @Override
    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }
}
