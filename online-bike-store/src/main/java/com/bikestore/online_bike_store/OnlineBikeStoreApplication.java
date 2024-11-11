package com.bikestore.online_bike_store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.bikestore.online_bike_store.repository")
@EntityScan(basePackages = "com.bikestore.online_bike_store.model")

public class OnlineBikeStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineBikeStoreApplication.class, args);
	}

}

