package com.example.accountservicedemo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // register this object in spring container
@RequestMapping("/account")
public class AccountServiceController {
	@Value("${server.port}") // injects server.port value present in property file to port variable
	private String port;
	
	@GetMapping(path="/balance")
	public ResponseEntity<Object> getBalance()	{
		// generating dummy account info along with port number
		Map<String,Object> map = new HashMap<>();
		map.put("balance", Double.valueOf(Math.random()*1234).doubleValue());
		map.put("port", port);
		return ResponseEntity.status(200).body(map);
	}
}
