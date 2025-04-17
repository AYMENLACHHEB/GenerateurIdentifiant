package com.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.dto.CritereDto;
import com.microservice.entity.Critere;
import com.microservice.service.CritereService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/criteria")
@Tag(name = "Identifiant", description = "Gestion des Critere de génération des identifiants")
public class CritereController {

    @Autowired
    private CritereService critereService;

    @PostMapping
    @Operation(summary = "Créer un critère",
               description = "création d'un nouveau critère")
    public ResponseEntity<Critere> createCriteria(@RequestBody CritereDto critereDto) {
        return ResponseEntity.ok(critereService.EnregistrerCritere(critereDto));
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Modifier un critère",
               description = "modification d'un critère")
    public ResponseEntity<Critere> majCriteria(@PathVariable Long id, @RequestBody CritereDto critereDto) {
        return ResponseEntity.ok(critereService.majCritere(id, critereDto));
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un critère",
    description = "suppression d'un critère à partir de son id")
    public ResponseEntity<Void> deleteCriteria(@PathVariable Long id) {
    	critereService.supprimerCritere(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un critère",
    description = "récupération d'un critère à partir de son id")
    public ResponseEntity<Critere> getCriteria(@PathVariable Long id) {
        return ResponseEntity.ok(critereService.recupererCritere(id));
    }
    
    @GetMapping
    @Operation(summary = "Récupérer tout les critères",
    description = "récupération de tout les critères")
    public ResponseEntity<List<Critere>> getAllCriteria() {
        return ResponseEntity.ok(critereService.recupererToutCriteres());
    }
    
    @GetMapping("/getAllDto")
    public ResponseEntity<List<CritereDto>> recupererToutCriteriaDto() {
        return ResponseEntity.ok(critereService.recupererToutCriteresDto());
    }
}

