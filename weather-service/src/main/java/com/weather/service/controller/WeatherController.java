package com.weather.service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.ribbon.proxy.annotation.Hystrix;

@RestController
public class WeatherController {
	
	@Value("${data}")
	private String data;

	@GetMapping("/weather/{city}")
	@Hystrix
	public double getTemp(@PathVariable("city") String city) {
		System.out.println(data);
		return Math.random();
	}
}
