package com.bikestore.online_bike_store.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;

@Entity
@Table(name = "customer_order")
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", nullable = false) 
    private Address address;

    @Valid
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
