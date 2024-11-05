package com.bikestore.online_bike_store.controller;

import com.bikestore.online_bike_store.model.Product;
import com.bikestore.online_bike_store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final ProductService productService;

    @Autowired
    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home(Model model) {
        // Retrieve a list of featured products from the ProductService
        List<Product> products = productService.findAllProducts();
        // Add the list of products to the model
        model.addAttribute("products", products);
        // Return the view name "index" to load index.html
        return "index";
    }
}
