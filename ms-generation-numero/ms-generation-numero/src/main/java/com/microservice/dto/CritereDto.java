package com.microservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CritereDto {
	private Long id;
	private String type;
	private int ordre;
	int longueur; // nombre de caractères à prendre (0 = tout)
	private String prefixe;
	private String suffixe;
	private String dateFormat; // utilisé seulement pour la date
	private int compteurInitial = 0; // utilisé seulement pour le compteur
	
}
