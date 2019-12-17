package com.microservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.services.AppService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class SquareController {

	@Autowired
	private AppService appService;

	@GetMapping("/square/{num}")
/*	@HystrixCommand(fallbackMethod="getResultFromSquareServiceBackup")*/
	public ResponseEntity<String> square(@PathVariable("num") String num) {
		return new ResponseEntity<>(appService.square(Double.parseDouble(num)), HttpStatus.OK);

	}
	
	public ResponseEntity<String>  getResultFromSquareServiceBackup(String num){
		return new ResponseEntity<>("oops! something went wrong",HttpStatus.OK);
		
	}
}
