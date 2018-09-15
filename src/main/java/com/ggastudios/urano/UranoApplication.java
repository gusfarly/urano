package com.ggastudios.urano;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ggastudios.urano.controller","com.ggastudios.urano.service"})
public class UranoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UranoApplication.class, args);
	}
}
