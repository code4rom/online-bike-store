package com.bikestore.online_bike_store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/index", "/css/**", "/images/**", "/register", "/login", "/products", "/products/{id}","/cart", "/cart/**", "/checkout")
                        .permitAll()  // Allow access to public paths and cart
                        .anyRequest().authenticated()  // All other requests require authentication
                )
                .formLogin(login -> login
                        .loginPage("/login")
                        .permitAll()
                )
                .logout(logout -> logout
                        .permitAll()
                );

        return http.build();
    }
}
