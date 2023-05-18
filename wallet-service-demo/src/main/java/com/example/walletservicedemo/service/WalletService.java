package com.example.walletservicedemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

// should use RestTemplate present in spring container & call Account microservice
@Service
public class WalletService {
	// use @Autowired to let spring to supply RestTemplate
	@Autowired
	private RestTemplate rest; // this object can send request using GET, POST, PUT, DELETE

	@Autowired
	private AccountClient accountClient;

	@CircuitBreaker(name="walletInstance",fallbackMethod = "fallback")
	public Wallet initializeWallet() {
		//using RestTemplate
//		String url = "http://AMS/account/balance";
//		Wallet wallet = rest.getForObject(url, Wallet.class);
//		wallet.setWalletNumber(Double.valueOf(wallet.getBalance() * 31).intValue());
//		wallet.setDescription("Account Microservice is running on port: " + wallet.getPort());
		//using feignclient
		System.out.println("*********** Inside method call ******************");
		Wallet wallet = accountClient.fetchAccountBalance();
		wallet.setWalletNumber(Double.valueOf(wallet.getBalance() * 31).intValue());
		wallet.setDescription("Account Microservice is running on port: " + wallet.getPort());
		return wallet;
	}
	
	public Wallet fallback(Throwable t)	{
		System.out.println("************** Fallback called **********");
		Wallet wallet = new Wallet();
		return wallet;
		
	}

}
