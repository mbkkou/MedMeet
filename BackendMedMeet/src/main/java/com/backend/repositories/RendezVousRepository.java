package com.backend.repositories;


import com.backend.dao.Docteur;
import com.backend.dao.Patient;
import com.backend.dao.RendezVous;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {

	List<RendezVous> findByDocteur(Docteur docteur);

	List<RendezVous> findByPatient(Patient patient);

    // Méthodes de requête spécifiques au repository
    
    // ...

}
