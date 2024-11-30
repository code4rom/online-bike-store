package com.bikestore.online_bike_store.service;

import com.bikestore.online_bike_store.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findById(Long id); // Find user by ID

    void deleteUserById(Long id); // Delete user by ID

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    void registerUser(User user);

    void saveUser(User user);

    List<User> findAllUsers();
}
