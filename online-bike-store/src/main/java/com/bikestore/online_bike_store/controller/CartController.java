package com.bikestore.online_bike_store.controller;



import com.bikestore.online_bike_store.model.CartItem;
import com.bikestore.online_bike_store.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public String viewCart(Model model) {
        List<CartItem> cartItems = cartService.getCartItems();
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("cartTotal", cartService.calculateCartTotal());
        return "cart";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam("productId") Long productId, @RequestParam("quantity") int quantity) {
        cartService.addProductToCart(productId, quantity);
        return "redirect:/cart";
    }
}
