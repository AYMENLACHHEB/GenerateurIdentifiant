package com.microservice.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.microservice.dto.CritereDto;
import com.microservice.entity.Critere;

@SpringBootTest
public class CriteriaServiceTest {

    @Autowired
    private CritereService criteriaService;
    
    @Autowired
    private CritereMapper criteriaMapper;

    @Test
    public void testSaveCriteria() {
    	CritereDto criteria_nom = new CritereDto();
    	criteria_nom.setType("Nom");
    	criteria_nom.setLongueur(3);
    	criteria_nom.setOrdre(1);
    	CritereDto criteria_prenom = new CritereDto();
    	criteria_prenom.setType("Prenom");
    	criteria_prenom.setLongueur(3);
    	criteria_prenom.setOrdre(1);

        Critere saved_nom = criteriaService.EnregistrerCritere(criteria_nom);
        Critere saved_prenom = criteriaService.EnregistrerCritere(criteria_prenom);
        assertNotNull(saved_nom.getType());
        assertNotNull(saved_prenom.getType());
    }
    
    @Test
    public void testCriteriaMapper() {
    	CritereDto criteria_nom = new CritereDto();
    	criteria_nom.setType("Nom");
    	criteria_nom.setLongueur(3);
    	criteria_nom.setOrdre(1);
    	CritereDto criteria_prenom = new CritereDto();
    	criteria_prenom.setType("Prenom");
    	criteria_prenom.setLongueur(3);
    	criteria_prenom.setOrdre(1);

    	Critere saved_nom = criteriaService.EnregistrerCritere(criteria_nom);
    	List<CritereDto> listInitial = criteriaService.recupererToutCriteresDto();
    	List<CritereDto> list = criteriaMapper.ConvertirEnDtoList(criteriaService.recupererToutCriteres());
    	
        assertTrue(!list.isEmpty());
    }
}

