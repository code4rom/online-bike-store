package com.bikestore.online_bike_store.repository;

import com.bikestore.online_bike_store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
