package com.backend.dao;


import java.util.Date;

import javax.persistence.Column;

import lombok.Data;

@Data
public class SignupRequest {
	//patient
    private String email_Patient;
    private String password_Patient;

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

    public String getPrenom_Patient() {
        return prenom_Patient;
    }

    public void setPrenom_Patient(String prenom_Patient) {
        this.prenom_Patient = prenom_Patient;
    }

    public String getNom_Patient() {
        return nom_Patient;
    }

    public void setNom_Patient(String nom_Patient) {
        this.nom_Patient = nom_Patient;
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

    private String prenom_Patient;
    private String nom_Patient;
    private Date birth_Patient;
    private String gender_Patient;
    
    //docteur

   
  
    public SignupRequest(String email_Patient, String password_Patient, String prenom_Patient, String nom_Patient, Date birth_Patient, String gender_Patient) {
        this.email_Patient = email_Patient;
        this.password_Patient = password_Patient;
        this.prenom_Patient = prenom_Patient;
        this.nom_Patient = nom_Patient;
        this.birth_Patient = birth_Patient;
        this.gender_Patient = gender_Patient;
    }
  


}
