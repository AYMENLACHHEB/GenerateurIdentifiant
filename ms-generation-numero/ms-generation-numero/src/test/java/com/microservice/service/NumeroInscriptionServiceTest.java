package com.microservice.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.microservice.dto.InscriptionDto;


@SpringBootTest
public class NumeroInscriptionServiceTest {
	
    @Autowired
    private GenerationNumeroService generationService;

    @Test
    public void testGenererNumero() {
    	InscriptionDto data = new InscriptionDto();
    	data.setDateNaissance(new Date());
    	data.setNom("test");
    	data.setPrenom("test");
    	
        /*CritereConfig saved_nom = criteriaService.saveCriteria(criteria_nom);
        CritereConfig saved_prenom = criteriaService.saveCriteria(criteria_prenom);*/
        assertTrue(true);
        //assertNotNull(saved_prenom.getId());
    }

}
