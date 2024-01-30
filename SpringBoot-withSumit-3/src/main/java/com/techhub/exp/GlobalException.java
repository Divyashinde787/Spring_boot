package com.techhub.exp;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.techhub.payload.ApiResponse;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler
	public ApiResponse resourceNotFound(ResourceNotFoundException ex) {
		
		ApiResponse res= new ApiResponse();
		res.setMessage(ex.getMessage());
		res.setSuccess(false);
		return res;
	}
	

}
