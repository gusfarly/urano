package com.ggastudios.urano;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;


// todo quitar eureka, no es necesario para esta aplicacion de momento al no utilizar microservicios(no son viables por el plan de heroku, ya que cada vez que se cae un micro deja de estar registrado.)
@SpringBootApplication
//@ComponentScan(basePackages = {"com.ggastudios.urano.controller","com.ggastudios.urano.service","com.ggastudios.urano.controller.advice"})
@ComponentScan(basePackages = {"com.ggastudios.urano.*"})
@Import({MvcConfigurer.class})
public class UranoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UranoApplication.class, args);
	}

}
