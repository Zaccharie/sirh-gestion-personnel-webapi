package dev.sirhgestionpersonnelwepapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.sirhgestionpersonnelwepapi.entite.Departement;
import dev.sirhgestionpersonnelwepapi.repository.DepartementRepository;

@RestController
@RequestMapping("/api/departements")
public class DepartementApiController {

	@Autowired
	private DepartementRepository departementRepo;
	
	@GetMapping
	public List<Departement> listerDepartements(){
		return departementRepo.findAll();
	}
}
