package dev.sirhgestionpersonnelwepapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sirhgestionpersonnelwepapi.entite.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {

}
