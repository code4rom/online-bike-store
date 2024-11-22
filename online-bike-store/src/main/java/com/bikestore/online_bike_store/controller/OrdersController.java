package com.bikestore.online_bike_store.controller;

import org.springframework.ui.Model;
import com.bikestore.online_bike_store.model.CustomerOrder;
import com.bikestore.online_bike_store.model.User;
import com.bikestore.online_bike_store.service.OrderService;
import com.bikestore.online_bike_store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    private final OrderService orderService;
    private final UserService userService;

    @Autowired
    public OrdersController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping
    public String userOrders(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userService.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<CustomerOrder> orders = orderService.findOrdersByUser(user);
        model.addAttribute("orders", orders);
        return "orders";
    }
}
