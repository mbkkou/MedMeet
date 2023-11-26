package com.backend.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.backend.dao.Docteur;
import com.backend.dao.LoginDocteurRequest;
import com.backend.dao.LoginRequest;
import com.backend.dao.LoginResponse;
import com.backend.dao.Patient;
import com.backend.services.errors.UserAlreadyExistsException;


public interface DocteurService {

	Docteur updateDocteur(Docteur docteur);

	void deleteDocteur(Long id);

	Docteur saveDocteur(Docteur docteur);

	Optional<Docteur> findDocteurById(Long id);

	List<Docteur> findAllDocteurs();


	Docteur signup(String email, String lastName, String firstName, String password, String specialite, String number)
			throws UserAlreadyExistsException;

	
	ResponseEntity<LoginResponse> login(LoginDocteurRequest loginDocteurRequest);

}
