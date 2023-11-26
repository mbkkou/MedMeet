package com.backend.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;



@Data
@Entity
@Table
public class Patient {
	
	
	public Patient() {
		super();
	}

	public Patient(Long iD_Patient, String nom_Patient, String prenom_Patient, String email_Patient,
			String password_Patient, Date birth_Patient, String gender_Patient) {
		super();
		ID_Patient = iD_Patient;
		this.nom_Patient = nom_Patient;
		this.prenom_Patient = prenom_Patient;
		this.email_Patient = email_Patient;
		this.password_Patient = password_Patient;
		this.birth_Patient = birth_Patient;
		this.gender_Patient = gender_Patient;
	}

	public Long getID_Patient() {
		return ID_Patient;
	}

	public void setID_Patient(Long ID_Patient) {
		this.ID_Patient = ID_Patient;
	}

	public String getNom_Patient() {
		return nom_Patient;
	}

	public void setNom_Patient(String nom_Patient) {
		this.nom_Patient = nom_Patient;
	}

	public String getPrenom_Patient() {
		return prenom_Patient;
	}

	public void setPrenom_Patient(String prenom_Patient) {
		this.prenom_Patient = prenom_Patient;
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

	public Date getBirth_Patient() {
		return birth_Patient;
	}

	public void setBirth_Patient(Date birth_Patient) {
		this.birth_Patient = birth_Patient;
	}

	public String getGender_Patient() {
		return gender_Patient;
	}

	public void setGender_Patient(String gender_Patient) {
		this.gender_Patient = gender_Patient;
	}

	@Id
	@Column(name = "ID_Patient")
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long ID_Patient;
	
	@Column(name = "nom_Patient")
	private String nom_Patient;
	
	@Column(name = "prenom_Patient")
	private String prenom_Patient;
	
	@Column(name = "email_Patient")
	public String email_Patient;
	
	@Column(name = "password_Patient")
	private String password_Patient;
	
	@Column(name = "birth_Patient")
	private Date birth_Patient;

	@Column(name = "Gender_Patient")
	private String gender_Patient;
	
}

