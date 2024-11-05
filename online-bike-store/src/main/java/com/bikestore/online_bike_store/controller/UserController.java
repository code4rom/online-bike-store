package com.bikestore.online_bike_store.controller;

import com.bikestore.online_bike_store.model.User;
import com.bikestore.online_bike_store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
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


   // @GetMapping("/register")
   // public String registerPage(Model model) {
    //    model.addAttribute("user", new User());
   //    return "register";
   // }

    @PostMapping("/register")
    public String registerUser(User user) {
        userService.saveUser(user);
        return "redirect:/login";
    }
}
