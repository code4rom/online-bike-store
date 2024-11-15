package com.bikestore.online_bike_store.repository;

import com.bikestore.online_bike_store.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Address, Long> {
}
