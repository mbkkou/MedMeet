package com.backend.dao;

import lombok.Data;

@Data

public class LoginRequest {
	public LoginRequest(String email_Patient, String password_Patient) {
		super();
		this.email_Patient = email_Patient;
		this.password_Patient = password_Patient;
	}

	public String getEmail_Patient() {
		return email_Patient;
	}

	public void setEmail_Patient(String email_Patient) {
		this.email_Patient = email_Patient;
	}

	public String getPassword_Patient() {
		return password_Patient;
	}

	public void setPassword_Patient(String password_Patient) {
		this.password_Patient = password_Patient;
	}

	private String email_Patient;


    private String password_Patient;

}
