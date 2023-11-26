package com.backend.dao;

import javax.persistence.*;
import java.time.LocalDateTime;

import lombok.Data;

@Data
@Entity
@Table(name = "rendez_vous")
public class RendezVous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateRendezVousStart() {
        return dateRendezVousStart;
    }

    public void setDateRendezVousStart(LocalDateTime dateRendezVousStart) {
        this.dateRendezVousStart = dateRendezVousStart;
    }

    public LocalDateTime getDateRendezVousEnd() {
        return dateRendezVousEnd;
    }

    public void setDateRendezVousEnd(LocalDateTime dateRendezVousEnd) {
        this.dateRendezVousEnd = dateRendezVousEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Column
    private LocalDateTime dateRendezVousStart;
    
    @Column(nullable = false)
    private LocalDateTime dateRendezVousEnd;
    
    @Column(nullable = false)
    private String description;

    
    @ManyToOne
    @JoinColumn(name = "ID_Patient")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "id_docteur")
    private Docteur docteur;

    // Ajoutez d'autres attributs ou méthodes au besoin

}
