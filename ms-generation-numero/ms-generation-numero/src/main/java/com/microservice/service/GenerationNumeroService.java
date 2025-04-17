package com.microservice.service;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.dto.CritereDto;
import com.microservice.dto.InscriptionDto;
import com.microservice.entity.NumeroGenere;
import com.microservice.repository.NumeroRepository;

@Service
public class GenerationNumeroService {

    private static final String COMPTEUR = "compteur";
	private static final String DATE_NAISSANCE = "dateNaissance";
	private static final String PRENOM = "prenom";
	private static final String NOM = "nom";
	private List<CritereDto> configuration;
    private final CompteurService compteurService;
    
    private final InterfaceFeignClient interfaceFeignClient;
    private final NumeroRepository numeroRepository;

    public GenerationNumeroService(CompteurService compteurService, InterfaceFeignClient interfaceFeignClient, NumeroRepository numeroRepository) {
        this.compteurService = compteurService;
        this.interfaceFeignClient =interfaceFeignClient;
        this.numeroRepository = numeroRepository;
    }

    public List<CritereDto> fournirToutlesCriteres() {
        List<CritereDto> criteres = interfaceFeignClient.fournirToutlesCriteres();
        return criteres;
    }
    
    public String genererNumero(InscriptionDto data) {
        StringBuilder resultat = new StringBuilder();
        configuration = fournirToutlesCriteres();
        
        // Trier par ordre
        configuration.stream()
            .sorted(Comparator.comparingInt(c -> c.getOrdre()))
            .forEach(config -> {
                String valeur = switch (config.getType()) {
                    case NOM -> tronquer(data.getNom().toUpperCase(), config.getLongueur());
                    case PRENOM -> tronquer(data.getPrenom().toUpperCase(), config.getLongueur());
                    case DATE_NAISSANCE -> {
                        SimpleDateFormat sdf = new SimpleDateFormat(config.getDateFormat());
                        yield sdf.format(data.getDateNaissance());
                    }
                    case COMPTEUR -> {
                        int compteur = compteurService.getNextCompteur("default", config.getCompteurInitial());
                        int longueur = config.getLongueur();

                        if (longueur > 0) {
                            String format = "%0" + longueur + "d";
                            yield String.format(format, compteur);
                        } else {
                            yield String.valueOf(compteur); // pas de padding si longueur invalide
                        }
                    }
				default -> throw new IllegalArgumentException("Unexpected value: " + config.getType());
                };
                resultat.append(config.getPrefixe() != null ? config.getPrefixe() : "")
                        .append(valeur)
                        .append(config.getSuffixe() != null ? config.getSuffixe() : "");
            });
        numeroRepository.save(new NumeroGenere(resultat.toString()));
        return resultat.toString();
    }

    private String tronquer(String texte, int longueur) {
        if (longueur == 0 || texte.length() <= longueur) return texte;
        return texte.substring(0, longueur);
    }
    
    public List<NumeroGenere> recupererToutNumeros() {
        return numeroRepository.findAll();
    }
    
}