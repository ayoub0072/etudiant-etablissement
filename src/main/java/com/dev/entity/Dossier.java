package com.dev.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Dossier")
public class Dossier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long type;
	@Column(name = "nom_dossier", length = 10)
	private String nom_dossier;

	@Column(name = "date_creation_dossier")
	@Temporal(TemporalType.DATE)
	private Date date_creation_dossier;

	@Column(name = "date_modification_dossier")
	@Temporal(TemporalType.DATE)
	private Date date_modification_dossier;

	@Column(name = "montant_dossier")
	private Double montant_dossier;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "etudiant_id")
	private Etudiant etudiant;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "etablissement_id")
	private Etablissement etablissement;
	
}
