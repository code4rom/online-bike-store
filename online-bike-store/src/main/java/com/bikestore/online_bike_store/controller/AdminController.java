package com.bikestore.online_bike_store.controller;

import com.bikestore.online_bike_store.model.Product;
import com.bikestore.online_bike_store.model.User;
import com.bikestore.online_bike_store.service.ProductService;
import com.bikestore.online_bike_store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class AdminController {

    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public AdminController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<User> users = userService.findAllUsers();
        List<Product> products = productService.findAllProducts();

        model.addAttribute("message", "Welcome to the Admin Dashboard!");
        model.addAttribute("users", users);
        model.addAttribute("products", products);

        return "dashboard";
    }

    @PostMapping("/dashboard/update-products")
    public String updateProducts(
            @RequestParam("productId") List<Long> productIds,
            @RequestParam("stockQuantity") List<Integer> stockQuantities,
            @RequestParam("productPrice") List<BigDecimal> productPrices) {

        for (int i = 0; i < productIds.size(); i++) {
            Long productId = productIds.get(i);
            Integer stockQuantity = stockQuantities.get(i);
            BigDecimal productPrice = productPrices.get(i);

            productService.updateProductStockAndPrice(productId, stockQuantity, productPrice);
        }

        return "redirect:/dashboard";
    }
}
