package com.bikestore.online_bike_store.service;

import com.bikestore.online_bike_store.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    // Injecting UserService
    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Find the user using UserService
        User user = userService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        // Build UserDetails object for Spring Security
        return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                .password(user.getPassword()) // Hashed password
                .roles(user.getRole().getName().replace("ROLE_", ""))
                .build();
    }
}
