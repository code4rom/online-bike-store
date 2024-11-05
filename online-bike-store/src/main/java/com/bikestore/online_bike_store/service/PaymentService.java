package com.bikestore.online_bike_store.service;

import com.bikestore.online_bike_store.model.Payment;
import java.util.List;
import java.util.Optional;

public interface PaymentService {
    List<Payment> findAllPayments();
    Optional<Payment> findPaymentById(Long id);
    void savePayment(Payment payment);
    void deletePaymentById(Long id);
}
