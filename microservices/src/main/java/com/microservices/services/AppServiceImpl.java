package com.microservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AppServiceImpl implements AppService {

	@Autowired
	private RestTemplate restTemplate;
	@Value("${square.service}")
	private String squareService;
	@Override
	public String square(double number) {
		ResponseEntity<String> res =  restTemplate.getForEntity(squareService+number, String.class);
		return res.getBody();
	}

}
