package com.bikestore.online_bike_store.model;

import jakarta.persistence.*;

@Entity
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Address shippingAddress;

    private String city;
    private String postalCode;

    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "user_id")  // Foreign key column in Order table
    private User user;

    // Getters and Setters
    public Long getId() { return id; }

    public Address getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(Address shippingAddress) { this.shippingAddress = shippingAddress; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public Payment getPayment() { return payment; }
    public void setPayment(Payment payment) { this.payment = payment; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
