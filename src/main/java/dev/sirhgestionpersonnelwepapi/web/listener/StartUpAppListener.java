package dev.sirhgestionpersonnelwepapi.web.listener;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.sirhgestionpersonnelwepapi.entite.Collaborateur;
import dev.sirhgestionpersonnelwepapi.entite.Departement;
import dev.sirhgestionpersonnelwepapi.repository.CollaborateurRepository;
import dev.sirhgestionpersonnelwepapi.repository.DepartementRepository;

@Component
public class StartUpAppListener {
	
	@Autowired
	private DepartementRepository departementRepo;
	
	@Autowired
	private CollaborateurRepository collaborateurRepo;
	
	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {
		// capture du démarrage de l'application
		// à un moment où le contexte Spring est complètement créé

		//generer jeu de données avec departements et collaborateurs
		Departement d1 = new Departement();
		d1.setNom("Resources Humaines");
		
		Departement d2 = new Departement();
		d2.setNom("Informatique");
		
		Departement d3 = new Departement();
		d3.setNom("Administration");
		
		departementRepo.save(d1);
		departementRepo.save(d2);
		departementRepo.save(d3);
		
		ZonedDateTime dateCreation = ZonedDateTime.now();
		
		Collaborateur co = new Collaborateur(
								"M01",
								"Meddah",
								"Zaccharie",
								"Developpeur",
								LocalDate.of(1991, Month.JULY, 20),
								"",
								"191674585210",
								"z.meddah@mail.com",
								"",
								dateCreation,
								"Credit Mutuel",
								"","",true,d2);
		
		collaborateurRepo.save(co);
	}

}
