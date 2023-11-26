package com.backend.dao;

import lombok.Data;

@Data
public class LoginDocteurRequest {
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	private String adresse;
    public LoginDocteurRequest(String adresse, String password) {
		super();
		this.adresse = adresse;
		this.password = password;
	}

}
