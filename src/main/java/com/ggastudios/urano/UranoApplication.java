package com.ggastudios.urano;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.*;


@SpringBootApplication
//@ComponentScan(basePackages = {"com.ggastudios.urano.controller","com.ggastudios.urano.service","com.ggastudios.urano.controller.advice"})
@ComponentScan(basePackages = {"com.ggastudios.urano.*"})
@Import({MvcConfigurer.class})
//@EnableEurekaClient
@EnableDiscoveryClient
public class UranoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UranoApplication.class, args);
	}

}
