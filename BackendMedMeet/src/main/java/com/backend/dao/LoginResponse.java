package com.backend.dao;

import lombok.Data;

@Data
public class LoginResponse {
	private String status;
    private String message;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Docteur getDocteur() {
		return docteur;
	}

	public void setDocteur(Docteur docteur) {
		this.docteur = docteur;
	}

	private Patient patient;
    private Docteur docteur;
	public LoginResponse(String status, String message,Patient patient) {
		super();
		this.status = status;
		this.message = message;
		this.patient=patient;
	}
	public LoginResponse(String status, String message,Docteur docteur) {
		super();
		this.status = status;
		this.message = message;
		this.docteur=docteur;
	}
	public LoginResponse(String status, String message) {
		super();
		this.status = status;
		this.message = message;
		
	}
}
