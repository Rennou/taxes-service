package com.taxes.taxesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * 
 * @author taous rennou
 *
 */
@SpringBootApplication
@EnableSwagger2
public class TaxesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxesServiceApplication.class, args);
	}

}

/*

http://localhost:8091/v2/api-docs. 
https://localhost:8091/swagger-ui.html,

*/