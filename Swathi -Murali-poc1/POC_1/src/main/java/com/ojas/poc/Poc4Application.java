package com.ojas.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableEurekaClient
@EnableSwagger2
@EnableAutoConfiguration(exclude = ErrorMvcAutoConfiguration.class)
public class Poc4Application {

	public static void main(String[] args) {
		SpringApplication.run(Poc4Application.class, args);
	}

//	@Bean
//	public Docket pocApis() {
//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.basePackage("com.ojas.poc.controller")).build();
//	}

}
