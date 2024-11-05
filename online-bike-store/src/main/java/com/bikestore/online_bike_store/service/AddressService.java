package com.bikestore.online_bike_store.service;

import com.bikestore.online_bike_store.model.Address;
import java.util.List;
import java.util.Optional;

// This interface defines the service methods for managing Address entities.
public interface AddressService {
    // Method to get a list of all addresses.
    List<Address> findAllAddresses();

    // Method to find an address by its ID.
    Optional<Address> findAddressById(Long id);

    // Method to save a new or updated address.
    void saveAddress(Address address);

    // Method to delete an address by its ID.
    void deleteAddressById(Long id);
}
