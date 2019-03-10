package com.dev.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dev.dto.EtudiantDTO;
import com.dev.entity.Etudiant;
import com.dev.exception.NotFoundException;
import com.dev.exception.TechnicalException;
import com.dev.mapper.EtudiantMapper;
import com.dev.repository.EtudiantRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EtudiantService {

	@Autowired
	private EtudiantRepository etudiantRepository;

	@Autowired
	private EtudiantMapper etudiantMapper;

	public List<EtudiantDTO> getAllEtudiant() {
		log.info("Afficher La list des Etudiants");
		List<Etudiant> listetudiant = etudiantRepository.findAll();
		List<EtudiantDTO> listetudiantDTO = etudiantMapper.mapToListDTO(listetudiant);
		return listetudiantDTO;

	}

	public EtudiantDTO getByIdEtudiant(long id) throws NotFoundException, TechnicalException {
		log.info("Afficher un Etudiant par son ID");
		Etudiant etudiant = etudiantRepository.findOne(id);
		if (etudiant == null) {
			throw new NotFoundException("L'etudiant n'est pas trouver !!!!");
		}
		EtudiantDTO etudiantDTO = etudiantMapper.mapToDTO(etudiant);
		return etudiantDTO;
	}

	public EtudiantDTO saveEtudiant(EtudiantDTO etudiantDTO) throws TechnicalException {
		if (etudiantDTO != null) {
			log.info("Creation d'un Etudiant");
			Etudiant etudiant = etudiantMapper.mapToEntity(etudiantDTO);
			Etudiant savedetudiant = etudiantRepository.save(etudiant);
			EtudiantDTO savedetudiantDTO = etudiantMapper.mapToDTO(savedetudiant);
			return savedetudiantDTO;
		} else {
			throw new TechnicalException("Error Techinque lors de la creation");
		}
	}

	public void deleteByIdEtudiant(Long id) throws TechnicalException {
		if (id != null) {
			log.info("supprimer l'etudiant");
			etudiantRepository.delete(id);
		} else {
			throw new TechnicalException("Error Techinque lors de la creation");
		}
	}

	public EtudiantDTO rechercheEtudiant(String nom, String prenom, Date dateNaissance) throws TechnicalException {
		if (nom != null && prenom != null && dateNaissance != null) {
			Etudiant etudiant = etudiantRepository.findByNomEtdiantAndPrenomEtudiantAndDateNaissance(nom, prenom,
					dateNaissance);
			EtudiantDTO etudiantDto = etudiantMapper.mapToDTO(etudiant);
			return etudiantDto;
		} else {
			throw new TechnicalException("Error Techinque lors de la recherche");
		}
	}
	
	public Page<EtudiantDTO> getPagesEtudiantByNom(String nom , Pageable pageable) throws TechnicalException {
		if (nom != null) {
			Page<Etudiant> etudiant = etudiantRepository.findAllByNomEtdiant(nom, pageable);
			List<EtudiantDTO> etudiantDto = etudiantMapper.mapToListDTO(etudiant.getContent());
			    return new PageImpl<>(etudiantDto, pageable, etudiant.getTotalElements());
		} else {
			throw new TechnicalException("Error Techinque lors de la recherche");
		}
	}
	
	public Page<EtudiantDTO> getAllPagesEtudiant(Pageable pageable) {
			Page<Etudiant> etudiant = etudiantRepository.findAll(pageable);
			List<EtudiantDTO> etudiantDto = etudiantMapper.mapToListDTO(etudiant.getContent());
			    return new PageImpl<>(etudiantDto, pageable, etudiant.getTotalElements());
		}
	
}
