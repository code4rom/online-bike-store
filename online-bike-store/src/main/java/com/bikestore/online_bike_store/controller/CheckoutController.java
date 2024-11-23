package com.bikestore.online_bike_store.controller;

import com.bikestore.online_bike_store.model.Address;
import com.bikestore.online_bike_store.model.CustomerOrder;
import com.bikestore.online_bike_store.model.Payment;
import com.bikestore.online_bike_store.model.User;
import com.bikestore.online_bike_store.service.CartService;
import com.bikestore.online_bike_store.service.OrderService;
import com.bikestore.online_bike_store.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

@Controller
public class CheckoutController {

    private final OrderService orderService;
    private final CartService cartService;
    private final UserService userService;

    @Autowired
    public CheckoutController(OrderService orderService, CartService cartService, UserService userService) {
        this.orderService = orderService;
        this.cartService = cartService;
        this.userService = userService;
    }

    @GetMapping("/checkout")
    public String checkoutPage(Model model) {
        CustomerOrder order = new CustomerOrder();
        order.setAddress(new Address()); // Initialize Address
        order.setPayment(new Payment()); // Initialize Payment
        model.addAttribute("order", order);
        return "checkout";
    }

    @PostMapping("/checkout")
    public String processCheckout(@AuthenticationPrincipal UserDetails userDetails,
                                  @ModelAttribute @Valid CustomerOrder order,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "checkout";
        }

        User user = userService.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        BigDecimal cartTotal = cartService.calculateCartTotal(user);
        order.getPayment().setAmount(cartTotal);
        order.setUser(user);

        orderService.saveOrder(order);
        cartService.clearCart(user);

        return "redirect:/checkout/confirmation";
    }

    @GetMapping("/checkout/confirmation")
    public String confirmationPage() {
        return "order-confirmation";
    }
}
