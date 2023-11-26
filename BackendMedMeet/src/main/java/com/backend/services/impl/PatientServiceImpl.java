package com.backend.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.dao.Patient;
import com.backend.repositories.PatientRepository;
import com.backend.services.PatientService;
import com.backend.services.errors.UserAlreadyExistsException;

@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	private final PatientRepository patientRepository; 

	public PatientServiceImpl(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}

	@Override
	public List<Patient> findAllPatients() {
		return patientRepository.findAll();
	}

	@Override
	public Optional<Patient> findbyIdPatient(Long id) {
		// TODO Auto-generated method stub
		return patientRepository.findById(id);
	}

	@Override
	public Patient savePatient(Patient patient) {
		// TODO Auto-generated method stub
		return  patientRepository.save(patient);
	}

	@Override
	public Patient modifyPatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientRepository.save(patient);
	}

	@Override
	public void deletePatient(Long id) {
		// TODO Auto-generated method stub
		patientRepository.deleteById(id);
	}
	@Override
	public Patient signup(String email, String password, String firstName, String lastName, Date dateOfBirth, String gender) throws UserAlreadyExistsException {
        // Check if user already exists
        if (patientRepository.findByEmail_Patient(email) != null) {
            throw new UserAlreadyExistsException("User with email " + email + " already exists");
        }
		String hashedPassword = bCryptPasswordEncoder.encode(password);


		// Create new patient object
        Patient patient = new Patient();
        patient.setEmail_Patient(email);
        patient.setPassword_Patient(hashedPassword);
        patient.setNom_Patient(lastName);
        patient.setPrenom_Patient(firstName);
        patient.setBirth_Patient(dateOfBirth);
        patient.setGender_Patient(gender);
        
        // Save patient to database
        return patientRepository.save(patient);
    }


}
