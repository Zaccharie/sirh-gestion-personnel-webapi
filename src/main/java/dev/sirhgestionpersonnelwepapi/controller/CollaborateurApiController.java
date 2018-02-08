package dev.sirhgestionpersonnelwepapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.sirhgestionpersonnelwepapi.entite.Collaborateur;
import dev.sirhgestionpersonnelwepapi.repository.CollaborateurRepository;

@RestController
@RequestMapping("api/collaborateurs")
public class CollaborateurApiController {

	@Autowired
	private CollaborateurRepository collaborateurRepo;
	
	@GetMapping
	public List<Collaborateur> listerCollaborateur(@RequestParam("departement") Optional<Integer> id){
		
		if(id.isPresent()) {
			return collaborateurRepo.findByDepartementId(id);
		}
		else {
			return collaborateurRepo.findAll();
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/{matricule}")
	public Collaborateur afficherCollaborateur(@PathVariable String matricule) {
		return collaborateurRepo.findByMatricule(matricule);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{matricule}")
	public void updateCollaborateur(@RequestBody Collaborateur collab, @PathVariable String matricule) {
		
		Collaborateur collabToUpdate = collaborateurRepo.findByMatricule(matricule);
		
		if(collabToUpdate != null) { //si le collaborateur existe
			collab.setId(collabToUpdate.getId());
			collaborateurRepo.save(collab);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/{matricule}/banque")
	public HashMap<String, String> collabInfoBanque(@PathVariable String matricule ){
		
		HashMap<String, String> coordonnesBanquaires = new HashMap<>();
		Collaborateur co = collaborateurRepo.findByMatricule(matricule);
		
		if(co != null) {
			coordonnesBanquaires.put("Banque", co.getBanque());
			coordonnesBanquaires.put("BIC", co.getBic());
			coordonnesBanquaires.put("IBAN", co.getIban());
		}
		
		return coordonnesBanquaires;
	}
	

	@RequestMapping(method = RequestMethod.PUT, value = "/{matricule}/banque")
	public void updateCoordonnesBanque(@RequestBody HashMap<String, String> coordoneesB, @PathVariable String matricule) {
		
		Collaborateur collabToUpdate = collaborateurRepo.findByMatricule(matricule);
		
		if(collabToUpdate != null) {
			collabToUpdate.setBanque(coordoneesB.get("Banque"));
			collabToUpdate.setBic(coordoneesB.get("BIC"));
			collabToUpdate.setIban(coordoneesB.get("IBAN"));
			collaborateurRepo.save(collabToUpdate);
		}
	}
	
}	
