package com.bikestore.online_bike_store.config;

import com.bikestore.online_bike_store.model.User;
import com.bikestore.online_bike_store.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
@Configuration
public class TestDataConfig {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            User user = new User();


            user.setUsername("testuser");
            user.setPassword("password123");
            user.setEmail("testuser@example.com");
            userRepository.save(user);
        };
    }
}
*/