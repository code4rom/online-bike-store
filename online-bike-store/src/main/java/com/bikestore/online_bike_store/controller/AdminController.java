package com.bikestore.online_bike_store.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("message", "Welcome to the Admin Dashboard!");
        return "dashboard";
    }
}
