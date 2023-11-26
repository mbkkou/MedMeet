package com.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.dao.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	@Query("SELECT p FROM Patient p WHERE p.email_Patient = :email_Patient")
    Patient findByEmail_Patient(@Param("email_Patient") String emailPatient);
}
