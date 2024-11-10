package com.bikestore.online_bike_store.controller;

import com.bikestore.online_bike_store.model.User;
import com.bikestore.online_bike_store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // Constructor-based dependency injection for the UserService.
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint to retrieve a user by ID.
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    // Endpoint to create or update a user.
    @PostMapping
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    // Endpoint to delete a user by ID.
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    // Registration page
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User()); // Bind a new User object to the form
        return "register"; // Thymeleaf template name for the registration page
    }

    // Registration handler
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        // Check if username or email already exists and show error message if so
        if (userService.existsByUsername(user.getUsername())) {
            model.addAttribute("usernameError", "Username is already taken");
            return "register";
        }
        if (userService.existsByEmail(user.getEmail())) {
            model.addAttribute("emailError", "Email is already registered");
            return "register";
        }

        userService.registerUser(user); // Register the user with password encoding
        return "redirect:/login"; // Redirect to the login page after successful registration
    }

}
