package com.bikestore.online_bike_store.controller;

import com.bikestore.online_bike_store.model.CustomerOrder;
import com.bikestore.online_bike_store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CheckoutController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/checkout")
    public String checkoutPage(Model model) {
        model.addAttribute("order", new CustomerOrder());
        return "checkout";
    }

    @PostMapping("/checkout")
    public String processCheckout(CustomerOrder order) {
        orderService.saveOrder(order);
        return "redirect:/order-confirmation";
    }
}
