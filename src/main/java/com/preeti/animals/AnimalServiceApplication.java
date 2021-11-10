package com.preeti.animals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AnimalServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AnimalServiceApplication.class, args);
	}
}
