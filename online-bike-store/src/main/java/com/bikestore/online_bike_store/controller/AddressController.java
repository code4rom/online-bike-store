package com.bikestore.online_bike_store.controller;

import com.bikestore.online_bike_store.model.Address;
import com.bikestore.online_bike_store.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    // Constructor-based dependency injection for the AddressService.
    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    // Endpoint to retrieve all addresses.
    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.findAllAddresses();
    }

    // Endpoint to retrieve an address by ID.
    @GetMapping("/{id}")
    public Optional<Address> getAddressById(@PathVariable Long id) {
        return addressService.findAddressById(id);
    }

    // Endpoint to create or update an address.
    @PostMapping
    public void saveAddress(@RequestBody Address address) {
        addressService.saveAddress(address);
    }

    // Endpoint to delete an address by ID.
    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressService.deleteAddressById(id);
    }
}
