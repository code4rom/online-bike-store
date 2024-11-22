package com.bikestore.online_bike_store.service;

import com.bikestore.online_bike_store.model.Role;
import com.bikestore.online_bike_store.model.User;
import com.bikestore.online_bike_store.repository.RoleRepository;
import com.bikestore.online_bike_store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
    @Override
    public void registerUser(User user) {
        // Log the registration attempt
        logger.debug("Registering user: " + user.getUsername());

        // Determine the role
        Role role;
        if ("admin".equalsIgnoreCase(user.getUsername())) {
            role = roleRepository.findByName("ROLE_ADMIN")
                    .orElseGet(() -> {
                        Role newAdminRole = new Role("ROLE_ADMIN");
                        return roleRepository.save(newAdminRole);
                    });
        } else {
            role = roleRepository.findByName("ROLE_USER")
                    .orElseGet(() -> {
                        Role newUserRole = new Role("ROLE_USER");
                        return roleRepository.save(newUserRole);
                    });
        }

        // Set the role
        user.setRole(role);

        // Encrypt password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save the user
        try {
            userRepository.save(user);
            logger.debug("User registered successfully: " + user.getUsername());
        } catch (Exception e) {
            logger.error("Error registering user", e);
            throw new RuntimeException("Could not register user", e);
        }
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
