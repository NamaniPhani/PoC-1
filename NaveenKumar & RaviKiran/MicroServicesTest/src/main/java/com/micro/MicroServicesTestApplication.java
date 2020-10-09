package com.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroServicesTestApplication {

	public static void main(String[] args) {
		System.out.println("eureka server executed");
		SpringApplication.run(MicroServicesTestApplication.class, args);
	}
}
