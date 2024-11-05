package com.bikestore.online_bike_store.controller;

import com.bikestore.online_bike_store.model.Payment;
import com.bikestore.online_bike_store.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    // Constructor-based dependency injection for the PaymentService.
    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Endpoint to retrieve all payments.
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.findAllPayments();
    }

    // Endpoint to retrieve a payment by ID.
    @GetMapping("/{id}")
    public Optional<Payment> getPaymentById(@PathVariable Long id) {
        return paymentService.findPaymentById(id);
    }
}

