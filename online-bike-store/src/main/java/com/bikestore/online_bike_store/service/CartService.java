package com.bikestore.online_bike_store.service;

import com.bikestore.online_bike_store.model.CartItem;
import java.util.List;

public interface CartService {
    List<CartItem> getCartItems();
    void addProductToCart(Long productId, int quantity);
    double calculateCartTotal();
}
