package com.backend.dao;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "Consultation")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consultation_id")
    private Long consultationId;

    

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id_docteur")
    private Docteur doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id_patient")
    private Patient patient;

    
    @Column(name = "compte_rendu")
    private String compte_rendu;
    

    @Lob
    @Column(name = "traitement_fichier")
    private byte[] traitementFichier;

    public Long getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(Long consultationId) {
        this.consultationId = consultationId;
    }




    public Docteur getDoctor() {
        return doctor;
    }

    public void setDoctor(Docteur doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }



    public byte[] getTraitementFichier() {
        return traitementFichier;
    }

    public void setTraitementFichier(byte[] traitementFichier) {
        this.traitementFichier = traitementFichier;
    }

    // Ajoutez les constructeurs, getters et setters ici
}
