package com.example.walletservicedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class WalletServiceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalletServiceDemoApplication.class, args);
	}
	
	//Register the RestTemplate in spring container
	//Use load balance in the RestTemplate
	
	@Bean	//register object returned from this method in spring container
	@LoadBalanced //helps in resolving physical address from instance-id
	public RestTemplate restTemplate(RestTemplateBuilder builder)	{
		return builder.build();
	}

}
