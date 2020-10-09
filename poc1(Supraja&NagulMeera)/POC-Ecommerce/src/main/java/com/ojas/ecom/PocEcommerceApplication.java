package com.ojas.ecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PocEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocEcommerceApplication.class, args);
	}

}
