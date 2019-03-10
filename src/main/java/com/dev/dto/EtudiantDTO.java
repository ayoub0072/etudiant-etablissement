package com.dev.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EtudiantDTO {
	private Long id;

	private String nom;

	private String prenom;

	private String email;

	private String cin;

	private Date dateNaissance;
}
