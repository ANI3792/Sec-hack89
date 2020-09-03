package com.service.impl;

import javax.jws.WebService;

import com.service.CalculatorSoapService;


@WebService(endpointInterface = "com.service.CalculatorSoapService")
public class CalculatorSoapServiceImpl implements CalculatorSoapService {

	@Override
	public int add(int a, int b) {
		
		return a+b;
	}

	@Override
	public int subtract(int a, int b) {
		
		return a-b;
	}

	@Override
	public int multiply(int a, int b) {
		
		return a*b;
	}

	@Override
	public int divide(int a, int b) {
		
		return a/b;
	}

	

}
