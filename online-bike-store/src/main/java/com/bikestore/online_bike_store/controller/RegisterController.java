package com.bikestore.online_bike_store.controller;

import com.bikestore.online_bike_store.model.User;
import com.bikestore.online_bike_store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {

    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    // Display the registration form
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User()); // Bind an empty User object for the form
        return "register"; // Display the register.html template
    }

    // Handle form submission and registration logic
    @PostMapping("/register")
    public String registerUser(
            @Valid @ModelAttribute("user") User user,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            // If there are validation errors, return to the registration form
            return "register";
        }

        // Check if the username or email is already taken
        if (userService.existsByUsername(user.getUsername())) {
            model.addAttribute("usernameError", "Username is already taken");
            return "register";
        }
        if (userService.existsByEmail(user.getEmail())) {
            model.addAttribute("emailError", "Email is already registered");
            return "register";
        }

        // Save the new user
        userService.saveUser(user);
        return "redirect:/login"; // Redirect to the login page upon successful registration
    }
}
