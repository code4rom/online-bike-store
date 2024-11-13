package com.bikestore.online_bike_store.service;

import com.bikestore.online_bike_store.model.CartItem;
import com.bikestore.online_bike_store.model.Product;
import com.bikestore.online_bike_store.model.User;
import com.bikestore.online_bike_store.repository.CartItemRepository;
import com.bikestore.online_bike_store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
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
    public List<CartItem> getCartItemsByUser(User user) {
        return cartItemRepository.findByUser(user);
    }

    @Override
    @Transactional
    public void addProductToCart(User user, Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        CartItem cartItem = cartItemRepository.findByUserAndProduct(user, product)
                .orElseGet(() -> new CartItem(user, product, 0));

        cartItem.setQuantity(cartItem.getQuantity() + quantity);
        cartItemRepository.save(cartItem);
    }

    @Override
    public void removeProductFromCart(User user, Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        cartItemRepository.findByUserAndProduct(user, product)
                .ifPresent(cartItemRepository::delete);
    }
    @Override
    @Transactional
    public void decreaseProductQuantity(User user, Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Optional<CartItem> cartItemOpt = cartItemRepository.findByUserAndProduct(user, product);
        if (cartItemOpt.isPresent()) {
            CartItem cartItem = cartItemOpt.get();
            if (cartItem.getQuantity() > 1) {
                cartItem.setQuantity(cartItem.getQuantity() - 1);
                cartItemRepository.save(cartItem);
            } else {
                cartItemRepository.delete(cartItem); // Remove if quantity is 1
            }
        }
    }

    @Override
    @Transactional
    public BigDecimal calculateCartTotal(User user) {
        return cartItemRepository.findByUser(user).stream()
                .map(item -> item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
