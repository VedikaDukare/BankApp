package com.techlabs.demo.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class RegistrationDto {
	
	private int userId;
	private String userName;
	private String password;
	private String role;
}
