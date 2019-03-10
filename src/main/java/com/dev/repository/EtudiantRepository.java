package com.dev.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.entity.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{

	public Etudiant findByNomEtdiantAndPrenomEtudiantAndDateNaissance(String nom,String prenom,Date datenaissance);
}
