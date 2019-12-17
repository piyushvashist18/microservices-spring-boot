package com.math.services.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.math.services.services.MathService;

@RestController
public class MathController {

	@Autowired
	private MathService mathService;
	@Autowired
	private Environment env;
	
	@GetMapping("/math/square/{num}")
	public ResponseEntity<String> square(@PathVariable("num") String num){
		return new ResponseEntity<>(String.valueOf(mathService.square(Double.parseDouble(num)))+ env.getProperty("local.server.port"),HttpStatus.OK);
	}
}
