package com.bikestore.online_bike_store.service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bikestore.online_bike_store.model.Role;
import com.bikestore.online_bike_store.model.User;
import com.bikestore.online_bike_store.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Role userRole;

    @BeforeEach
    public void setup() {
        // Initialize a role for testing purposes
        userRole = new Role();
        userRole.setName("ROLE_USER");
    }

    @Test
    @Transactional(propagation = Propagation.NOT_SUPPORTED) // Ensures the user is saved permanently
    public void testRegisterUser() {
        User newUser = new User();
        newUser.setUsername("newUser");
        newUser.setPassword(passwordEncoder.encode("password"));
        newUser.setRole(userRole);

        userService.registerUser(newUser);

        Optional<User> savedUser = userRepository.findByUsername("newUser");
        assertTrue(savedUser.isPresent());
        assertTrue(passwordEncoder.matches("password", savedUser.get().getPassword()));
    }

    @Test
    public void testLoadUserByUsername_UserExists() {
        User user = new User();
        user.setUsername("existingUser");
        user.setPassword(passwordEncoder.encode("password"));
        user.setRole(userRole);
        userRepository.save(user);

        User loadedUser = (User) userService.loadUserByUsername("existingUser");

        assertNotNull(loadedUser);
        assertEquals("existingUser", loadedUser.getUsername());
    }

    @Test
    public void testLoadUserByUsername_UserNotFound() {
        Exception exception = assertThrows(UsernameNotFoundException.class, () -> {
            userService.loadUserByUsername("nonExistentUser");
        });

        assertEquals("User not found with username: nonExistentUser", exception.getMessage());
    }
}
