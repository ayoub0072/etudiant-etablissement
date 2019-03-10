package com.dev.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dev.dto.EtudiantDTO;
import com.dev.entity.Etudiant;

@Mapper(componentModel = "spring")
public interface EtudiantMapper {

	@Mapping(target="id", source="etudiant.idEtudiant")
    @Mapping(target="nom", source="etudiant.nomEtdiant")
    @Mapping(target="prenom", source="etudiant.prenomEtudiant")
	EtudiantDTO mapToDTO(Etudiant etudiant);

	List<EtudiantDTO> mapToListDTO(List<Etudiant> etudiant);

	@Mapping(target="idEtudiant", source="etudiantdto.id")
    @Mapping(target="nomEtdiant", source="etudiantdto.nom")
    @Mapping(target="prenomEtudiant", source="etudiantdto.prenom")
	Etudiant mapToEntity(EtudiantDTO etudiantdto);

	List<Etudiant> mapToListEntity(List<EtudiantDTO> etudiant);
}
