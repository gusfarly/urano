package com.ggastudios.urano;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.ggastudios.urano.controller","com.ggastudios.urano.service","com.ggastudios.urano.advice"})
@ComponentScan(basePackages = {"com.ggastudios.urano.*"})
@Configuration
public class UranoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UranoApplication.class, args);
	}
}
