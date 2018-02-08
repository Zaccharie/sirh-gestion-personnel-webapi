package dev.sirhgestionpersonnelwepapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sirhgestionpersonnelwepapi.entite.Collaborateur;

public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer>{
	
	List<Collaborateur> findByDepartementId(Optional<Integer> id);
	
	Collaborateur findByMatricule(String matricule);

}
