package com.backend.services.impl;



import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backend.dao.Docteur;
import com.backend.dao.RendezVous;
import com.backend.repositories.DocteurRepository;
import com.backend.repositories.RendezVousRepository;
import com.backend.services.RendezvousService;

@Service
public class RendezvousServiceImp implements RendezvousService {
    private RendezVousRepository rendezVousRepository ;
    private DocteurRepository docteurRepository;

    public RendezvousServiceImp(RendezVousRepository rendezVousRepository , DocteurRepository docteurRepository) {
        this.rendezVousRepository = rendezVousRepository;
        this.docteurRepository=docteurRepository;
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public RendezVous updateRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public void deleteRendezVous(Long id) {
        rendezVousRepository.deleteById(id);
    }

    @Override
    public RendezVous findRendezVousById(Long id) {
        return rendezVousRepository.findById(id).orElse(null);
    }

	@Override
	public List<RendezVous> findAllRendezvous() {
		// TODO Auto-generated method stub
		return rendezVousRepository.findAll();
	}
	@Override
	public RendezVous modifierRendezVous(Long id, RendezVous rendezVousModifie) {
        Optional<RendezVous> optionalRendezVous = rendezVousRepository.findById(id);
        if (optionalRendezVous.isPresent()) {
            RendezVous rendezVous = optionalRendezVous.get();
            // Mettre à jour les propriétés du rendez-vous avec les nouvelles valeurs
            rendezVous.setDescription(rendezVousModifie.getDescription());
            rendezVous.setDocteur(rendezVous.getDocteur());
            rendezVous.setPatient(rendezVousModifie.getPatient());
            rendezVous.setDateRendezVousStart(rendezVousModifie.getDateRendezVousStart());
            rendezVous.setDateRendezVousEnd(rendezVousModifie.getDateRendezVousEnd());
         
            return rendezVousRepository.save(rendezVous);
        } else {
           System.out.println("Rendez-vous non trouvé avec l'ID : " + id);
           return null;
        }
    }
    // Ajoutez d'autres méthodes spécifiques au service des rendez-vous si nécessaire
	
	@Override
	public List<RendezVous> findRendezVousByDocteur(Long docteurId) {
	    Docteur docteur = docteurRepository.findById(docteurId).orElse(null);
	    if (docteur != null) {
	        return rendezVousRepository.findByDocteur(docteur);
	    } else {
	        return Collections.emptyList();
	    }
	}

}
