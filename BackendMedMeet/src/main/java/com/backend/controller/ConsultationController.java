package com.backend.controller;

import com.backend.dao.Consultation;
import com.backend.dao.Patient;
import com.backend.repositories.ConsultationRepository;
import com.backend.repositories.PatientRepository;
import com.backend.services.impl.ConsultationServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@CrossOrigin( origins = "http://localhost:4200/")
@RestController
@RequestMapping("/consultation")
public class ConsultationController {
    private final ConsultationServiceImp consultationService;
    private final PatientRepository patientRepository;
    private final ConsultationRepository consultationRepository;

    @Autowired
    public ConsultationController(ConsultationServiceImp consultationService, PatientRepository patientRepository, ConsultationRepository consultationRepository) {
        this.consultationService = consultationService;
		this.patientRepository = patientRepository;
		this.consultationRepository = consultationRepository;
    }

    @PostMapping
    public ResponseEntity<Consultation> saveConsultation(@RequestBody Consultation consultation) {
        Consultation savedConsultation = consultationService.saveConsultation(consultation);
        return new ResponseEntity<>(savedConsultation, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Consultation>> getAllConsultations() {
        List<Consultation> consultations = consultationService.getAllConsultations();
        return new ResponseEntity<>(consultations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consultation> getConsultationById(@PathVariable Long id) {
        Optional<Consultation> consultation = consultationService.getConsultationById(id);
        return consultation.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consultation> updateConsultation(@PathVariable Long id, @RequestBody Consultation consultation) {
        Optional<Consultation> existingConsultation = consultationService.getConsultationById(id);
        if (existingConsultation.isPresent()) {
            consultation.setConsultationId(id);
            Consultation updatedConsultation = consultationService.updateConsultation(consultation);
            updatedConsultation.setConsultationId(id);
            return new ResponseEntity<>(updatedConsultation, HttpStatus.OK);
        } else {
        	consultation.setConsultationId(id);
            consultationService.saveConsultation(consultation);
            return new ResponseEntity<>(consultation, HttpStatus.OK);
        }
		
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsultation(@PathVariable Long id) {
        Optional<Consultation> existingConsultation = consultationService.getConsultationById(id);
        if (existingConsultation.isPresent()) {
            consultationService.deleteConsultation(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Transactional
    @GetMapping("/patient/{id}/consultations")
    public ResponseEntity<List<Consultation>> getConsultationsByPatientId(@PathVariable("id") Long patientId) {
        System.out.println("Fetching consultations for patient with ID: " + patientId);
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);

        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            List<Consultation> consultationList = consultationRepository.findByPatient(patient);
            System.out.println("List of consultations associated with the patient: ");
            for (Consultation consultation : consultationList) {
                System.out.println(consultation.getPatient());
            }
            return ResponseEntity.ok(consultationList);
        } else {
        	System.out.println("jo");
            return ResponseEntity.notFound().build();
            
        }
    }

    
}
