package com.microservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AccountController {

	@Autowired
	private RestTemplate restTemplate;
	@Value("${account.service}")
	private String accountService;
	
	@PostMapping("/account/deposit")
	public String deposit(@RequestParam("accountnumber") long accountNumber, 
			 @RequestParam("amount") int amount, 
			 @RequestParam("type") String type) {
		restTemplate.postForObject(accountService+"?accountnumber="+accountNumber+"&amount="+amount+"&type="+type, null, String.class);
		return "Amount deposited";
	}
}
