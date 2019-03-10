package com.dev.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DossierDTO {

	private Long type;
	
	private String nom_dossier;

	private Date date_creation_dossier;

	private Date date_modification_dossier;

	private Double montant_dossier;

	private EtudiantDTO etudiant;
	
	private EtablissementDTO etablissement;
	
}
