package com.example.accountservicedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // registers instance in service discovery
public class AccountServiceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceDemoApplication.class, args);
	}

}
