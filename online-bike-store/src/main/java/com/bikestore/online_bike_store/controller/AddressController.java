package com.bikestore.online_bike_store.controller;

import com.bikestore.online_bike_store.model.Address;
import com.bikestore.online_bike_store.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.findAllAddresses();
    }

    @GetMapping("/{id}")
    public Optional<Address> getAddressById(@PathVariable Long id) {
        return addressService.findAddressById(id);
    }

    @PostMapping
    public void saveAddress(@RequestBody Address address) {
        addressService.saveAddress(address); // Corrected method name
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressService.deleteAddressById(id);
    }
}
