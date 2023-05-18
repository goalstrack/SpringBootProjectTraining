package com.example.walletservicedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.walletservicedemo.service.Wallet;
import com.example.walletservicedemo.service.WalletService;

@RestController
@RequestMapping("/wallet")
public class WalletController {
	@Autowired
	private WalletService walletService;

	@GetMapping("/fetchBalance")
	public ResponseEntity<Object> fetchBalance() {
		Wallet wallet = walletService.initializeWallet();
		return ResponseEntity.status(200).body(wallet);
	}

}
