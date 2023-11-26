package com.backend.dao;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class SignupdocteurRequest {

	 private String nom;
	    private String prenom;
	    private String specialite;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

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

	public String getNumeroTelephone() {
		return numeroTelephone;
	}

	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

	@Size(min = 8, max = 15)
	private String password;
	    private String adresse;
	    private String numeroTelephone;

	  public SignupdocteurRequest(String nom,String prenom,String specialite,String password,String adresse,String numeroTelephone) {
	    	this.adresse=adresse;
	    	this.nom=nom;
	    	this.prenom=prenom;
	    	this.numeroTelephone=numeroTelephone;
	    	this.password=password;
	    	this.specialite=specialite;
	    }

}
