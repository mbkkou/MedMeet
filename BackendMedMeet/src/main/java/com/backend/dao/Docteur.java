package com.backend.dao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "docteur")
public class Docteur {

    public Long getId_docteur() {
        return id_docteur;
    }

    public void setId_docteur(Long id_docteur) {
        this.id_docteur = id_docteur;
    }

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_docteur;

    @NotNull(message = "Name is required")
    @Column
    private String nom;

    @NotNull(message = "Lastname is required")
    @Column
    private String prenom;

    @NotNull(message = "Speciality is required")
    @Column
    private String specialite;


    @NotNull(message = "Password is required")
    @Size(min = 8, max = 15)
    @Column
    private String password;


    @NotNull(message = "Adress is required")
    @Column
    private String adresse;

    @NotNull(message = "Phone number is required")

    @Column
    private String numeroTelephone;



}
