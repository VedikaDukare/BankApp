package com.techlabs.demo.exception;


import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserApiException extends BaseException{
	public UserApiException(HttpStatus status, String message) {
		super(message, status);
		// TODO Auto-generated constructor stub
	}
	private HttpStatus status;
	private String message;

}
