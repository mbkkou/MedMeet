package com.backend.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.backend.dao.Patient;
import com.backend.services.errors.UserAlreadyExistsException;

public interface PatientService {
	List<Patient> findAllPatients();
	Optional<Patient> findbyIdPatient(Long id);
	Patient savePatient(Patient patient);
	Patient modifyPatient(Patient patient);
	void deletePatient(Long id);
	Patient signup(String email, String password, String firstName, String lastName, Date dateOfBirth, String gender)
			throws UserAlreadyExistsException;
	

}
