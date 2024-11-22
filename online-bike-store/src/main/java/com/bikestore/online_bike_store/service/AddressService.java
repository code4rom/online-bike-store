package com.bikestore.online_bike_store.service;

import com.bikestore.online_bike_store.model.Address;
import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<Address> findAllAddresses();
    Optional<Address> findAddressById(Long id);
    Address saveAddress(Address address);
    void deleteAddressById(Long id);
}
