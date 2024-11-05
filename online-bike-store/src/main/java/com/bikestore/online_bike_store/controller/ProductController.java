package com.bikestore.online_bike_store.controller;

import com.bikestore.online_bike_store.model.Product;
import com.bikestore.online_bike_store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Display all products on the product list page
    @GetMapping("/products")  // Ensure this matches the intended URL
    public String productList(Model model) {
        model.addAttribute("products", productService.findAllProducts());
        return "product-list";  // Maps to product-list.html in templates/
    }

    // Display details for a single product on the product detail page
    @GetMapping("/products/{id}")
    public String productDetail(@PathVariable Long id, Model model) {
        Optional<Product> product = productService.findProductById(id);
        product.ifPresent(value -> model.addAttribute("product", value));
        return product.isPresent() ? "product-detail" : "redirect:/products";
    }
}
