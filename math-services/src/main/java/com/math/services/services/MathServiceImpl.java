package com.math.services.services;

import org.springframework.stereotype.Service;

@Service
public class MathServiceImpl implements MathService {

	@Override
	public double square(double number) {
		return number*number;
	}

}
