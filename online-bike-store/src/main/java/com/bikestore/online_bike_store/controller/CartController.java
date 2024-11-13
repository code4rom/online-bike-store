package com.bikestore.online_bike_store.controller;

import com.bikestore.online_bike_store.model.User;
import com.bikestore.online_bike_store.service.CartService;
import com.bikestore.online_bike_store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final UserService userService;

    @Autowired
    public CartController(CartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }

    @GetMapping
    public String viewCart(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userService.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        model.addAttribute("cartItems", cartService.getCartItemsByUser(user));
        model.addAttribute("cartTotal", cartService.calculateCartTotal(user));
        return "cart";
    }

    @PostMapping("/add")
    public String addToCart(@AuthenticationPrincipal UserDetails userDetails, @RequestParam("productId") Long productId, @RequestParam("quantity") int quantity) {
        User user = userService.findByUsername(userDetails.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));
        cartService.addProductToCart(user, productId, quantity);
        return "redirect:/cart";
    }

    @GetMapping("/increase/{productId}")
    public String increaseQuantity(@PathVariable Long productId, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.findByUsername(userDetails.getUsername()).orElseThrow();
        cartService.addProductToCart(user, productId, 1); // Increase quantity by 1
        return "redirect:/cart";
    }

    @GetMapping("/decrease/{productId}")
    public String decreaseQuantity(@PathVariable Long productId, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.findByUsername(userDetails.getUsername()).orElseThrow();
        cartService.decreaseProductQuantity(user, productId);
        return "redirect:/cart";
    }

    @GetMapping("/remove/{productId}")
    public String removeItem(@PathVariable Long productId, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userService.findByUsername(userDetails.getUsername()).orElseThrow();
        cartService.removeProductFromCart(user, productId);
        return "redirect:/cart";
    }
}
