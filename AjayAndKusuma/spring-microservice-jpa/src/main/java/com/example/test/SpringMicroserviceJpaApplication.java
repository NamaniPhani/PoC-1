package com.example.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringMicroserviceJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroserviceJpaApplication.class, args);
	}

}
