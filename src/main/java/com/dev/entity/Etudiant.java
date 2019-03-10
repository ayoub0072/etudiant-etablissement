package com.dev.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name="Etudiant")
public class Etudiant {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEtudiant;
	
	@Column(name="nomEtdiant",length=8 ,nullable=false)
	private String nomEtdiant;
	
	@Column(name="prenomEtudiant",length=10,nullable=false)
	private String prenomEtudiant;
	
	@Column(name="email",length=30,nullable=false)
	private String email;
	
	@Column(name="cin")
	private String cin;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dateNaissance")
	private Date dateNaissance;
	
	 @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 private List<Dossier> etudiants;
}
