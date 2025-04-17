package com.microservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.dto.CritereDto;
import com.microservice.dto.InscriptionDto;
import com.microservice.entity.NumeroGenere;
import com.microservice.service.GenerationNumeroService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController 
@RequestMapping("/api/generate")
@Tag(name = "Identifiant", description = "API pour la génération d'identifiants")
public class GenererIdentificatUniqueController {

    @Autowired
    private GenerationNumeroService generationService;

    @GetMapping
    @Operation(summary = "Récupérer la liste des critères",
               description = "Récupérer la liste des critères a partir du micro service ms-configuration-numero")
    public ResponseEntity<List<CritereDto>> fournirToutlesCriteres() {
        return ResponseEntity.ok(generationService.fournirToutlesCriteres());
    }
    
    @GetMapping("/inscriptions")
    @Operation(summary = "Récupérer la liste des numéro générer",
               description = "Récupérer la liste des numéro générer")
    public ResponseEntity<List<NumeroGenere>> recupererToutNumeros() {
        return ResponseEntity.ok(generationService.recupererToutNumeros());
    }
    
    @PostMapping
    @Operation(summary = "Générer un identifiant unique",
               description = "Génère un identifiant en fonction des données fournies (nom, prénom, date de naissance, compteur, etc.)")
    public ResponseEntity<Map<String, String>> generNumberoUnique(@RequestBody InscriptionDto data) {
        String uniqueNumber = generationService.genererNumero(data);
        Map<String, String> response = new HashMap<>();
        response.put("uniqueNumber", uniqueNumber);
        return ResponseEntity.ok(response);
    }
}