package com.backend.controller;


import com.backend.dao.Docteur;
import com.backend.dao.LoginDocteurRequest;
import com.backend.dao.LoginResponse;
import com.backend.dao.Patient;
import com.backend.dao.SignupRequest;
import com.backend.dao.SignupdocteurRequest;
import com.backend.repositories.DocteurRepository;
import com.backend.services.DocteurService;
import com.backend.services.errors.UserAlreadyExistsException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/docteurs")
public class DocteurController {

    private final DocteurService docteurService;
    private final DocteurRepository docteurRepository;

    public DocteurController(DocteurService docteurService,DocteurRepository docteurRepository) {
        this.docteurService = docteurService;
		this.docteurRepository = docteurRepository;
    }

    @GetMapping
    public List<Docteur> getAllDocteurs() {
        return docteurService.findAllDocteurs();
    }

    @GetMapping("/{id}")
    public Optional<Docteur> getDocteurById(@PathVariable Long id) {
        return docteurService.findDocteurById(id);
    }

    @PostMapping
    public Docteur createDocteur(@RequestBody Docteur docteur) {
        return docteurService.saveDocteur(docteur);
    }

    @PutMapping("/{id}")
    public Docteur updateDocteur(@PathVariable Long id, @RequestBody Docteur docteur) {
        docteur.setId_docteur(id);
        return docteurService.updateDocteur(docteur);
    }

    @DeleteMapping("/{id}")
    public void deleteDocteur(@PathVariable Long id) {
        docteurService.deleteDocteur(id);
    }
    
    @PostMapping("/signup")
	public Docteur signup(@RequestBody SignupdocteurRequest signupRequest) throws UserAlreadyExistsException {
		return docteurService.signup(signupRequest.getAdresse(),signupRequest.getNom(), signupRequest.getPrenom(),signupRequest.getPassword(), signupRequest.getSpecialite() , signupRequest.getNumeroTelephone());
	}
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginDocteurRequest loginDocteurRequest) {
        Docteur docteur = docteurRepository.findByEmail_Docteur(loginDocteurRequest.getAdresse());

        if (docteur == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new LoginResponse("error", "User not found"));
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (!passwordEncoder.matches(loginDocteurRequest.getPassword(), docteur.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse("error", "Invalid credentials"));
        }

        return ResponseEntity.ok(new LoginResponse("success", "Login successful", docteur));
    }
}

