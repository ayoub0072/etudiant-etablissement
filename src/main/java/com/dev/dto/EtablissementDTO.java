package com.dev.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EtablissementDTO {

	private Long idEtablissement;

	private String nomEtablissement;

	private String addresseEtablissement;

	private String telEtablissement;
}
