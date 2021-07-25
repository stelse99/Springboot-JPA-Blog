package com.scp.blog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	public String handlerArgumentException(Exception e) {
		return "<h1>"+e.getMessage()+"</h1>";		
	}
	
//	@ExceptionHandler(value = IllegalArgumentException.class)
//	public String handlerArgumentException(IllegalArgumentException e) {
//		return "<h1>"+e.getMessage()+"</h1>";		
//	}


}