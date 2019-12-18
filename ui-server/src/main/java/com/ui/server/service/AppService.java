package com.ui.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AppService {
	@Autowired
	RestTemplate restTemplate;
	@Value("${weatherurl}")
	private String weatherServiceUrl;
	

	public Double get(String city) {
		ResponseEntity<Double> res =  restTemplate.getForEntity(weatherServiceUrl+city, Double.class);
		return res.getBody();
	}
}
