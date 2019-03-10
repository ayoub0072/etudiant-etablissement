package com.dev.entity;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Etablissement")
public class Etablissement {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEtablissement;
	
	@Column(name="nomEtablissement",length=8)
	private String nomEtablissement;
	
	@Column(name="addresseEtablissement",length=10)
	private String addresseEtablissement;
	
	@Column(name="telEtablissement",length=15)
	private String telEtablissement;
	
	 @OneToMany(mappedBy = "etablissement", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 private List<Dossier> etablissements;
}
