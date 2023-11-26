package com.backend.services.impl;

import com.backend.dao.Consultation;
import com.backend.repositories.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultationServiceImp {
    private final ConsultationRepository consultationRepository;

    @Autowired
    public ConsultationServiceImp(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    public List<Consultation> getAllConsultations() {
        return consultationRepository.findAll();
    }

    public Optional<Consultation> getConsultationById(Long id) {
        return consultationRepository.findById(id);
    }

    public Consultation updateConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    public void deleteConsultation(Long id) {
        consultationRepository.deleteById(id);
    }
}

