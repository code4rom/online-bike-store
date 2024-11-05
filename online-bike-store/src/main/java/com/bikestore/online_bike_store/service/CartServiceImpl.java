package com.bikestore.online_bike_store.service;

import com.bikestore.online_bike_store.model.CartItem;
import com.bikestore.online_bike_store.model.Product;
import com.bikestore.online_bike_store.repository.CartItemRepository;
import com.bikestore.online_bike_store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CartServiceImpl(CartItemRepository cartItemRepository, ProductRepository productRepository) {
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<CartItem> getCartItems() {
        return cartItemRepository.findAll();
    }

    @Override
    public void addProductToCart(Long productId, int quantity) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        // Check if the product is already in the cart
        CartItem cartItem = cartItemRepository.findByProductId(productId).orElse(null);
        if (cartItem != null) {
            // Update quantity if item already exists
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        } else {
            // Add new item if it doesn’t exist
            cartItem = new CartItem(product, quantity);
        }

        cartItemRepository.save(cartItem);
    }

    @Override
    public double calculateCartTotal() {
        return cartItemRepository.findAll().stream()
                .map(item -> item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .doubleValue();
    }
}
