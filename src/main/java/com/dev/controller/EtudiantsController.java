package com.dev.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.dto.EtudiantDTO;
import com.dev.exception.NotFoundException;
import com.dev.exception.TechnicalException;
import com.dev.service.EtudiantService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class EtudiantsController {

	@Autowired
	private EtudiantService etudiantService;
	
	@GetMapping("/etudiants")
	public List<EtudiantDTO> getAllEtudiants(){
		return etudiantService.getAllEtudiant();
	}
	
	@GetMapping("/etudiants/{id}")
	public EtudiantDTO getByIdEtudiant(@PathVariable Long id) throws TechnicalException, NotFoundException{
		return etudiantService.getByIdEtudiant(id);
	}
	
	@PostMapping("/etudiants")
	public EtudiantDTO saveEtudiant(@RequestBody EtudiantDTO etudiantDto) throws Exception{
		return etudiantService.saveEtudiant(etudiantDto);
	}
	
	@DeleteMapping("/etudiants/{id}")
	public void deleteByIdEtudiant(@PathVariable Long id) throws Exception{
		 etudiantService.deleteByIdEtudiant(id);
	}
	
	@GetMapping("/etudiants/")
	public  EtudiantDTO rechercheEtudiant(@RequestParam(value="nom") String nom,@RequestParam(value="prenom")  String prenom, @RequestParam(value="dateNaissance") @DateTimeFormat(pattern="yyyy-MM-dd") Date dateNaissance) throws Exception{
		return etudiantService.rechercheEtudiant(nom, prenom, dateNaissance);
	}
	
}
