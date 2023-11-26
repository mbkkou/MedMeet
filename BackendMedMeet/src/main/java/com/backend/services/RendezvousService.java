package com.backend.services;

import java.util.List;

import com.backend.dao.RendezVous;

public interface RendezvousService {

	RendezVous saveRendezVous(RendezVous rendezVous);

	RendezVous updateRendezVous(RendezVous rendezVous);

	void deleteRendezVous(Long id);

	RendezVous findRendezVousById(Long id);

	List<RendezVous> findAllRendezvous();

	RendezVous modifierRendezVous(Long id, RendezVous rendezVousModifie);
	
	List<RendezVous> findRendezVousByDocteur(Long docteurId);



}
