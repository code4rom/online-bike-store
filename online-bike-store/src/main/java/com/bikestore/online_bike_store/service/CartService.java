package com.bikestore.online_bike_store.service;

import com.bikestore.online_bike_store.model.CartItem;
import com.bikestore.online_bike_store.model.User;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {
    List<CartItem> getCartItemsByUser(User user);
    void addProductToCart(User user, Long productId, int quantity);
    void removeProductFromCart(User user, Long productId);
    void decreaseProductQuantity(User user, Long productId);
    BigDecimal calculateCartTotal(User user);
}
