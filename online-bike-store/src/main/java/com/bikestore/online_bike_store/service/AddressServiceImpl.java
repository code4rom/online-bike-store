package com.bikestore.online_bike_store.service;

import com.bikestore.online_bike_store.model.Address;
import com.bikestore.online_bike_store.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> findAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> findAddressById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddressById(Long id) {
        addressRepository.deleteById(id);
    }
}
