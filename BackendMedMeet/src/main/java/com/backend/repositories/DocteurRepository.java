package com.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.dao.Docteur;

@Repository
public interface DocteurRepository extends JpaRepository<Docteur, Long> {
	@Query("SELECT p FROM Docteur p WHERE p.adresse = :adresse")
	Docteur findByEmail_Docteur(String adresse);
	Docteur findById(long doctorId);

	


}
