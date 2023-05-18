package com.example.walletservicedemo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("http://AMS/")
public interface AccountClient {
	@GetMapping("/account/balance") // get request
	public Wallet fetchAccountBalance(); // spring boot automatically provides implementation

}
