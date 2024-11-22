package com.bikestore.online_bike_store.repository;

import com.bikestore.online_bike_store.model.CustomerOrder;
import com.bikestore.online_bike_store.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<CustomerOrder, Long> {
    List<CustomerOrder> findByUser(User user);
}
