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

    // View Cart
    @GetMapping
    public String viewCart(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        if (userDetails == null) {
            return "redirect:/login"; // Redirect to login if user  not authenticated
        }

        User user = userService.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        model.addAttribute("cartItems", cartService.getCartItemsByUser(user));
        model.addAttribute("cartTotal", cartService.calculateCartTotal(user));
        return "cart";
    }

    // Add Item to Cart
    @PostMapping("/add")
    public String addToCart(@AuthenticationPrincipal UserDetails userDetails,
                            @RequestParam("productId") Long productId,
                            @RequestParam("quantity") int quantity) {

        if (userDetails == null) {
            return "redirect:/login"; // Redirect to login if user not authenticated
        }

        User user = userService.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        cartService.addProductToCart(user, productId, quantity);
        return "redirect:/cart";
    }

    // Increase Quantity
    @GetMapping("/increase/{productId}")
    public String increaseQuantity(@PathVariable Long productId, @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return "redirect:/login";
        }

        User user = userService.findByUsername(userDetails.getUsername()).orElseThrow();
        cartService.addProductToCart(user, productId, 1); // Increase quantity by 1
        return "redirect:/cart";
    }

    // Decrease Quantity
    @GetMapping("/decrease/{productId}")
    public String decreaseQuantity(@PathVariable Long productId, @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return "redirect:/login";
        }

        User user = userService.findByUsername(userDetails.getUsername()).orElseThrow();
        cartService.decreaseProductQuantity(user, productId);
        return "redirect:/cart";
    }

    // Remove Item from Cart
    @GetMapping("/remove/{productId}")
    public String removeItem(@PathVariable Long productId, @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return "redirect:/login";
        }

        User user = userService.findByUsername(userDetails.getUsername()).orElseThrow();
        cartService.removeProductFromCart(user, productId);
        return "redirect:/cart";
    }

    // Model Attribute for Cart Item Count (Used in Header)
    @ModelAttribute("cartItemCount")
    public Integer getCartItemCount(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails != null) {
            User user = userService.findByUsername(userDetails.getUsername()).orElse(null);
            if (user != null) {
                return cartService.getCartItemsByUser(user).size();
            }
        }
        return 0; // Show zero if not logged in or cart is empty
    }
}
