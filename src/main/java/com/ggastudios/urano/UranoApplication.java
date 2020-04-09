package com.ggastudios.urano;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

// todo quitar eureka, no es necesario para esta aplicacion de momento al no utilizar microservicios(no son viables por el plan de heroku, ya que cada vez que se cae un micro deja de estar registrado.)
@SpringBootApplication
//@ComponentScan(basePackages = {"com.ggastudios.urano.controller","com.ggastudios.urano.service","com.ggastudios.urano.controller.advice"})
@ComponentScan(basePackages = {"com.ggastudios.urano.*"})
@Configuration
public class UranoApplication {

	@Autowired
	private static MessageSource messageSource;

	public static void main(String[] args) {
		SpringApplication.run(UranoApplication.class, args);
	}

	public static MessageSource getMessageSource() {
		return messageSource;
	}

}
