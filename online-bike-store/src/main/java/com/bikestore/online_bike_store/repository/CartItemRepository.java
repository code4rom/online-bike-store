package com.bikestore.online_bike_store.repository;

import com.bikestore.online_bike_store.model.CartItem;
import com.bikestore.online_bike_store.model.Product;
import com.bikestore.online_bike_store.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUser(User user);
    Optional<CartItem> findByUserAndProduct(User user, Product product);
}
