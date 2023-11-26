package com.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dao.LoginRequest;
import com.backend.dao.LoginResponse;
import com.backend.dao.Patient;
import com.backend.dao.SignupRequest;
import com.backend.repositories.PatientRepository;
import com.backend.services.PatientService;
import com.backend.services.errors.UserAlreadyExistsException;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/patient")
public class PatientController {
	
	private final PatientService patientService;
	private final PatientRepository patientRepository; 
	
	public PatientController(PatientService patientService, PatientRepository patientRepository) {
		super();
		this.patientService = patientService;
		this.patientRepository = patientRepository;
		
	}


	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
		Patient patient = patientRepository.findByEmail_Patient(loginRequest.getEmail_Patient());

		if (patient == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new LoginResponse("error", "User not found"));
		}

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if (!passwordEncoder.matches(loginRequest.getPassword_Patient(), patient.getPassword_Patient())) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse("error", "Invalid credentials"));
		}

		return ResponseEntity.ok(new LoginResponse("success", "Login successful", patient));
	}
	@PostMapping("/signup")
	public Patient signup(@RequestBody SignupRequest signupRequest) throws UserAlreadyExistsException {
		return patientService.signup(signupRequest.getEmail_Patient(), signupRequest.getPassword_Patient(), signupRequest.getPrenom_Patient(), signupRequest.getNom_Patient(), signupRequest.getBirth_Patient(), signupRequest.getGender_Patient());
	}
	@GetMapping
	public List<Patient> findallPatients(){
		return patientService.findAllPatients();
	}
	@GetMapping("/{id}")
	public Optional<Patient> findPatientByid(@PathVariable Long id) {
		return patientService.findbyIdPatient(id);
		
	}
	@PostMapping
	public Patient savePatient(@RequestBody Patient patient ) {
		return patientService.savePatient(patient);
	}
	@PutMapping
	public Patient modifyPatient(@RequestBody Patient patient ) {
		return patientService.modifyPatient(patient);
	}
	@DeleteMapping("/{id}")
	public void deletePatient(@PathVariable Long id ) {
		 patientService.deletePatient(id);
	}

}
