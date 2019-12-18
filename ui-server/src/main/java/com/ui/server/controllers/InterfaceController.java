package com.ui.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ui.server.service.AppService;

@RestController
public class InterfaceController {
	
	@Autowired
	private AppService appService;
	
	@GetMapping("/weather/{city}")
	@HystrixCommand(fallbackMethod="getResultFromFallback")
	public String getTemp(@PathVariable("city") String city) {
		return String.valueOf(appService.get(city));
	}
	
	private String getResultFromFallback(String city) {
		return "Something went wrong!!";
	}

}
