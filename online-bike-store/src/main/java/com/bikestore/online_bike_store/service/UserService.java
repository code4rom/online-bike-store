package com.bikestore.online_bike_store.service;

import com.bikestore.online_bike_store.model.User;
import java.util.Optional;

public interface UserService {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Optional<User> findByUsername(String username);
    Optional<User> findById(Long id);
    void saveUser(User user);
    void deleteUserById(Long id);
}
