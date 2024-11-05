package com.bikestore.online_bike_store.service;

import com.bikestore.online_bike_store.model.Address;
import com.bikestore.online_bike_store.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    // Reference to the AddressRepository for database operations.
    private final AddressRepository addressRepository;

    // Constructor-based dependency injection of the AddressRepository.
    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    // Fetch all addresses from the database.
    @Override
    public List<Address> findAllAddresses() {
        return addressRepository.findAll();
    }

    // Find an address by its ID.
    @Override
    public Optional<Address> findAddressById(Long id) {
        return addressRepository.findById(id);
    }

    // Save an address entity to the database.
    @Override
    public void saveAddress(Address address) {
        addressRepository.save(address);
    }

    // Delete an address by its ID.
    @Override
    public void deleteAddressById(Long id) {
        addressRepository.deleteById(id);
    }
}
