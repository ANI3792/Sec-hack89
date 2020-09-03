package com.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style=Style.RPC)
public interface CalculatorSoapService {
	@WebMethod
	public int add(int a,int b);
	@WebMethod
	public int subtract(int a, int b);
	@WebMethod
	public int multiply(int a, int b);
	@WebMethod
	public int divide(int a, int b);
}
