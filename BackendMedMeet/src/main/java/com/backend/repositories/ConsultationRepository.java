package com.backend.repositories;

import com.backend.dao.Consultation;
import com.backend.dao.Patient;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

	List<Consultation> findByPatient(Patient patient);
    // Vous pouvez ajouter des méthodes de requête personnalisées ici si nécessaire
}