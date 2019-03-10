package com.dev.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.entity.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{

	public Etudiant findByNomEtdiantAndPrenomEtudiantAndDateNaissance(String nom,String prenom,Date datenaissance);
	
	public Page<Etudiant> findAllByNomEtdiant(String nom, Pageable pageable);
	
	public Page<Etudiant> findAll(Pageable pageable);
}
