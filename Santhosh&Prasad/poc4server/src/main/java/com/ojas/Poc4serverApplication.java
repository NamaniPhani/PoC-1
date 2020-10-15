package com.ojas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Poc4serverApplication {

	public static void main(String[] args) {
		SpringApplication.run(Poc4serverApplication.class, args);
	}

}
