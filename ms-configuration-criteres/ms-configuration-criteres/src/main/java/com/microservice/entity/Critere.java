package com.microservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "critere_config")
public class Critere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private int ordre;
    private int longueur; // nombre de caractères à prendre (0 = tout)
    String prefixe;
    String suffixe;
    String dateFormat; // utilisé seulement pour la date
    int compteurInitial = 0; // utilisé seulement pour le compteur
    
    
    
	public Critere(Long id, String type, int ordre, int longueur, String prefixe, String suffixe,
			String dateFormat, int compteurInitial) {
		super();
		this.id = id;
		this.type = type;
		this.ordre = ordre;
		this.longueur = longueur;
		this.prefixe = prefixe;
		this.suffixe = suffixe;
		this.dateFormat = dateFormat;
		this.compteurInitial = compteurInitial;
	}
	
	
	
	public Critere() {
		super();
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getOrdre() {
		return ordre;
	}
	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}
	public int getLongueur() {
		return longueur;
	}
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}
	public String getPrefixe() {
		return prefixe;
	}
	public void setPrefixe(String prefixe) {
		this.prefixe = prefixe;
	}
	public String getSuffixe() {
		return suffixe;
	}
	public void setSuffixe(String suffixe) {
		this.suffixe = suffixe;
	}
	public String getDateFormat() {
		return dateFormat;
	}
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	public int getCompteurInitial() {
		return compteurInitial;
	}
	public void setCompteurInitial(int compteurInitial) {
		this.compteurInitial = compteurInitial;
	}
    
}


