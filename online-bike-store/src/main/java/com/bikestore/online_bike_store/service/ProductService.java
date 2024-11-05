package com.bikestore.online_bike_store.service;

import com.bikestore.online_bike_store.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAllProducts();
    Optional<Product> findProductById(Long id);
    void saveProduct(Product product);
    void deleteProductById(Long id);

    void addProductToCart(Long id, int quantity);

    List<Product> getAllProducts();
}
