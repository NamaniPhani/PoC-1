package com.ojas.poc4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableEurekaClient
@ComponentScan({"com.ojas.poc4.controller","com.ojas.poc4.service","com.ojas.poc4.exception"})
@EntityScan("com.ojas.poc4.model")
@EnableJpaRepositories("com.ojas.poc4.repository")
//@EnableAutoConfiguration(exclude = { CustomExceptionHandler.class,WebMvcAutoConfiguration.class })
@SpringBootApplication
public class Poc4Application {

	public static void main(String[] args) {
		SpringApplication.run(Poc4Application.class, args);
	}

}
